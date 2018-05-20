package com.fb.hacks.server.provider.facebook;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
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
public class FacebookFactory {

    private final HttpServletRequest request;

    public Facebook getFacebook() {
        String token = getAccessToken().get();
        return new FacebookTemplate(token);
    }

    private Optional<String> getAccessToken() {
        return Stream.of(request.getCookies())
                .filter(x -> Objects.equals(x.getName(), FacebookCookie.TOKEN.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

}
