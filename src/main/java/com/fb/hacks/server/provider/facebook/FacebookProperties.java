package com.fb.hacks.server.provider.facebook;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FacebookProperties {

    private final String appId;
    private final String appSecret;

    public FacebookProperties(@Value("${spring.social.facebook.appId}") String appId,
                              @Value("${spring.social.facebook.appSecret}") String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

}
