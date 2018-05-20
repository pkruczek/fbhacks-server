package com.fb.hacks.server.user;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
public class UserGetDto {

    private final String id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final Set<String> interests;

    public static UserGetDto of(User user){
        return UserGetDto.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .interests(user.getInterests())
                .build();
    }
}




