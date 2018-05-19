package com.fb.hacks.server.matcher;

import lombok.Data;

import java.util.List;

@Data

public class AllResults {
    private final List<MatchResult> matchedGroups;
    private final List<MatchResult> nonExistentGroups;
}
