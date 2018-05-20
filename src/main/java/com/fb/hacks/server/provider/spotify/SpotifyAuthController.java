package com.fb.hacks.server.provider.spotify;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController("/")
public class SpotifyAuthController {

    public static final String REDIRECT_URI ="http://localhost:8080/spotify";

    private final SpotifyApi spotifyApi;
    private final AuthorizationCodeUriRequest authorizationCodeUriRequest;

    public SpotifyAuthController(SpotifyProperties spotifyProperties) {
        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(spotifyProperties.getAppId())
                .setClientSecret(spotifyProperties.getAppSecret())
                .setRedirectUri(SpotifyHttpManager.makeUri(SpotifyAuthController.REDIRECT_URI))
                .build();

        ;
        this.authorizationCodeUriRequest = this.spotifyApi.authorizationCodeUri()
                .state("x4xkmn9pu3j6ukrs8n")
                .scope("user-read-birthdate,user-read-email,user-top-read")
                .show_dialog(true)
                .build();
    }

    @GetMapping("/spotify-auth")
    public RedirectView createSpotifyAuthorization() {
        return new RedirectView(createSpotifyAuthorizationURL());
    }

    @GetMapping("/spotify")
    @ResponseStatus(HttpStatus.OK)
    public void getToken(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletResponse response) {
        AuthorizationCodeCredentials token = createSpotifyAccessToken(code);
        response.addCookie(new Cookie(SpotifyCookie.ACCESS_TOKEN.getName(), token.getAccessToken()));
        response.addCookie(new Cookie(SpotifyCookie.REFRESH_TOKEN.getName(), token.getRefreshToken()));
    }

    private String createSpotifyAuthorizationURL() {
        URI uri = authorizationCodeUriRequest.execute();
        return uri.toString();
    }

    @SneakyThrows
    private AuthorizationCodeCredentials createSpotifyAccessToken(String code) {
        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
                .build();
        return authorizationCodeRequest.execute();
    }

}
