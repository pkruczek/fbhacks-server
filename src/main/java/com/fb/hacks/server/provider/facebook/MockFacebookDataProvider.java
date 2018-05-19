package com.fb.hacks.server.provider.facebook;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Map;
import java.util.Set;

public class MockFacebookDataProvider implements IntegratedServiceDataProvider {

    private static final Map<String, Set<String>> INTERESTS = interests();

    @Override
    public Set<String> getInterests(String userId) {
        return INTERESTS.get(userId);
    }

    private static Map<String, Set<String>> interests() {
        return ImmutableMap.<String, Set<String>>builder()
                .put("greg", ImmutableSet.of("girls", "chinese cartoons", "beer"))
                .put("john", ImmutableSet.of("songs", "obama", "beer"))
                .put("paul", ImmutableSet.of("trump", "cars", "concerts"))
                .put("rob", ImmutableSet.of("songs", "beer", "girls"))
                .build();
    }

}
