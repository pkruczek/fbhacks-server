package com.fb.hacks.server.provider;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
final class InterestNormalizer {

    static String normalize(String interest) {
        return interest.replaceAll(" ", "_").toLowerCase();
    }

}
