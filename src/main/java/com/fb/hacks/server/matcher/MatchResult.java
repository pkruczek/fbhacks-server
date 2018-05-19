package com.fb.hacks.server.matcher;

import lombok.Data;

import java.util.Set;

@Data
public class MatchResult {
    private final double intersectionPercentResult;
    private final Set<String> intersectionInterests;
}
