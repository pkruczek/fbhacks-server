package com.fb.hacks.server.provider;

import java.util.Set;
import java.util.stream.Collectors;

public interface IntegratedServiceDataProvider {

    Set<String> getRawInterests(String userId);

    default Set<String> getInterests(String userId) {
        return getRawInterests(userId)
                .stream()
                .map(InterestNormalizer::normalize)
                .collect(Collectors.toSet());
    }

}
