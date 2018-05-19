package com.fb.hacks.server.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserSaveDto userSaveDto) {
        User userToInsert = User.builder()
                .username(userSaveDto.getUsername())
                .firstName(userSaveDto.getFirstName())
                .lastName(userSaveDto.getLastName())
                .interests(userSaveDto.getInterests())
                .build();
        userRepository.save(userToInsert);
    }
}
