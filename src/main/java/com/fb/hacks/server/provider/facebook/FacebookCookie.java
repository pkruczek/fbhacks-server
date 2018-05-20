package com.fb.hacks.server.provider.facebook;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FacebookCookie {
    TOKEN("FB-TOKEN");

    @Getter
    private final String name;

}
