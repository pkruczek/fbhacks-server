package com.fb.hacks.server.group;

import com.fb.hacks.server.user.User;
import lombok.Data;
import lombok.experimental.Wither;

import java.util.Set;

@Wither
@Data
public class GroupSaveDto {
    private final Set<String> interests;
    private final Set<User> members;
}
