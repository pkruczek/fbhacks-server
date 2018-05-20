package com.fb.hacks.server.group;

import com.fb.hacks.server.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;

import java.util.Set;

@Wither
@Data
@Builder
public class GroupSaveDto {
    private final Set<String> interests;
    private final Set<User> members;
}
