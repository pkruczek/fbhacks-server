package com.fb.hacks.server.provider.spotify;

import com.wrapper.spotify.SpotifyApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class SpotifyFactory {

    private final HttpServletRequest request;

    public SpotifyApi getSpotifyApi() {
        return SpotifyApi.builder()
                .setAccessToken(getCookie(SpotifyCookie.ACCESS_TOKEN).get())
                .setRefreshToken(getCookie(SpotifyCookie.REFRESH_TOKEN).get())
                .build();
    }

    private Optional<String> getCookie(SpotifyCookie cookie) {
        return Stream.of(request.getCookies())
                .filter(x -> Objects.equals(x.getName(), cookie.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

}
