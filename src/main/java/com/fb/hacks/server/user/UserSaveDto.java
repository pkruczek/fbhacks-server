package com.fb.hacks.server.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserSaveDto {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final Set<String> interests;
}
