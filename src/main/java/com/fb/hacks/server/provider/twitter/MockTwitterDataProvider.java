package com.fb.hacks.server.provider.twitter;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class MockTwitterDataProvider implements IntegratedServiceDataProvider {

    private static final Map<String, Set<String>> INTERESTS = interests();

    @Override
    public Set<String> getRawInterests(String userId) {
        return INTERESTS.get(userId);
    }

    private static Map<String, Set<String>> interests() {
        return ImmutableMap.<String, Set<String>>builder()
                .put("greg", ImmutableSet.of("criminals", "movies", "wine"))
                .put("john", ImmutableSet.of("programming", "obama", "beer"))
                .put("paul", ImmutableSet.of("trump", "football", "concerts"))
                .put("anna", ImmutableSet.of("horses", "wine", "books"))
                .build();
    }

}
