package com.fb.hacks.server.provider.spotify;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SpotifyCookie {
    ACCESS_TOKEN("SPOTIFY-ACCESS-TOKEN"),
    REFRESH_TOKEN("SPOTIFY-REFRESH-TOKEN");

    @Getter
    private final String name;

}
