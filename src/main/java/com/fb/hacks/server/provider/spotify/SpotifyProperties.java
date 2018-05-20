package com.fb.hacks.server.provider.spotify;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SpotifyProperties {


    private final String appId;
    private final String appSecret;

    public SpotifyProperties(@Value("${spotify.appId}") String appId,
                              @Value("${spotify.appSecret}") String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }


}
