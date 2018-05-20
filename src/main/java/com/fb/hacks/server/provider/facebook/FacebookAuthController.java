package com.fb.hacks.server.provider.facebook;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class FacebookAuthController {

    private final FacebookProperties facebookProperties;

    @GetMapping("/facebook-auth")
    public RedirectView createFacebookAuthorization(){
        return new RedirectView(createFacebookAuthorizationURL());
    }

    @GetMapping("/facebook")
    @ResponseStatus(HttpStatus.OK)
    public void getToken(@RequestParam("code") String code, HttpServletResponse response){
        String token = createFacebookAccessToken(code);
        response.addCookie(new Cookie(FacebookCookie.TOKEN.getName(), token));
    }

    private String createFacebookAuthorizationURL(){
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookProperties.getAppId(),
                facebookProperties.getAppSecret());
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8080/facebook");
        params.setScope("public_profile,email,user_birthday,user_likes");
        return oauthOperations.buildAuthorizeUrl(params);
    }

    private String createFacebookAccessToken(String code) {
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookProperties.getAppId(), facebookProperties.getAppSecret());
        AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, "http://localhost:8080/facebook", null);
        return accessGrant.getAccessToken();
    }

}
