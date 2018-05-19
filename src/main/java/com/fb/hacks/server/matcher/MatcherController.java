package com.fb.hacks.server.matcher;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class MatcherController {
    private final InterestMatcher interestMatcher;

    @GetMapping("matcher/{userId}")
    AllResults getMatches(@PathVariable String userId) {
        return interestMatcher.matchAll(userId);
    }

}
