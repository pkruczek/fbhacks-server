package com.fb.hacks.server.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserCreateDto {
    private final String userId;
}
