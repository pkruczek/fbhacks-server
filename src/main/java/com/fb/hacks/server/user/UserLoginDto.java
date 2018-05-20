package com.fb.hacks.server.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginDto {
    private final String username;
    private final String password;
}
