package com.fb.hacks.server.matcher;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.google.common.collect.Sets.intersection;
import static java.util.Collections.emptySet;

@Service
public class InterestMatcher {

    @Autowired
    private Set<IntegratedServiceDataProvider> integratedServiceDataProviders;

    public MatchResult matchInterests(String currentUserId, String targetUserId) {
        Set<String> currentUserAllInterests = integratedServiceDataProviders.stream()
                .map(it -> it.getInterests(currentUserId))
                .reduce(emptySet(), Sets::union);

        Set<String> targetUserAllInterests = integratedServiceDataProviders.stream()
                .map(it -> it.getInterests(targetUserId))
                .reduce(emptySet(), Sets::union);

        Sets.SetView<String> intersectionResult = intersection(currentUserAllInterests, targetUserAllInterests);

        return new MatchResult(calculateIntersectionPercentResult(currentUserAllInterests, intersectionResult), intersectionResult);
    }

    private double calculateIntersectionPercentResult(Set<String> currentUserAllInterests, Set<String> intersection) {
        return 100.0 * intersection.size() / currentUserAllInterests.size();
    }

}
