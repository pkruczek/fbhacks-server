package com.fb.hacks.server.matcher;

import com.fb.hacks.server.group.Group;
import com.fb.hacks.server.group.GroupRepository;
import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import com.fb.hacks.server.user.User;
import com.fb.hacks.server.user.UserRepository;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.intersection;
import static java.util.Collections.emptySet;
import static java.util.Comparator.comparing;

@Service
@RequiredArgsConstructor
public class InterestMatcher {
    private final Set<IntegratedServiceDataProvider> integratedServiceDataProviders;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public AllResults matchAll(String currentUserId) {
        Set<String> currentUserAllInterests = extractCurrentUserInterests(currentUserId);
        List<MatchResult> allGroups = groupRepository.findAll().stream()
                .map(it -> matchInterestsForGroup(currentUserAllInterests, it))
                .sorted(comparing(it -> (int) -it.getIntersectionPercentResult()))
                .collect(Collectors.toList());
        List<MatchResult> allMatchResultUsers = userRepository.findAll().stream()
                .map(it -> matchInterestsForUser(currentUserAllInterests, it))
                .sorted(comparing(it -> (int) -it.getIntersectionPercentResult()))
                .collect(Collectors.toList());
        return new AllResults(allGroups, allMatchResultUsers);
    }

    private MatchResult matchInterestsForGroup(Set<String> currentUserAllInterests, Group group) {
        Set<String> targetGroupInterest = group.getInterests();
        Set<String> intersectionResult = intersection(currentUserAllInterests, targetGroupInterest);
        return new MatchResult(calculateIntersectionPercentResult(currentUserAllInterests, intersectionResult), intersectionResult);
    }

    private MatchResult matchInterestsForUser(Set<String> currentUserAllInterests, User targetUser) {
        Set<String> targetUserAllInterests = targetUser.getInterests();
        Set<String> intersectionResult = intersection(currentUserAllInterests, targetUserAllInterests);
        return new MatchResult(calculateIntersectionPercentResult(currentUserAllInterests, intersectionResult), intersectionResult);
    }

    private Set<String> extractCurrentUserInterests(String currentUserId) {
        return integratedServiceDataProviders.stream()
                    .map(it -> it.getInterests(currentUserId))
                    .reduce(emptySet(), Sets::union);
    }

    private double calculateIntersectionPercentResult(Set<String> currentUserAllInterests, Set<String> intersection) {
        return 100.0 * intersection.size() / currentUserAllInterests.size();
    }

}
