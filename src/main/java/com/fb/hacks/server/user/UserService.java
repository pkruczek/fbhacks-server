package com.fb.hacks.server.user;

import com.fb.hacks.server.utils.ObjectIdConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserCreateDto createUser(UserSaveDto userSaveDto) {
        User userToInsert = User.builder()
                .username(userSaveDto.getUsername())
                .firstName(userSaveDto.getFirstName())
                .lastName(userSaveDto.getLastName())
                .interests(userSaveDto.getInterests())
                .build();
        userRepository.save(userToInsert);
        return UserCreateDto.builder().userId(ObjectIdConverter.toString(userToInsert.getId())).build();
    }

    public UserGetDto login(UserLoginDto userLoginDto) {
        User user = userRepository.findOneByUsername(userLoginDto.getUsername());
        if (!user.getPassword().equals(userLoginDto.getPassword())) {
            throw new RuntimeException("User Password incorrect!");
        }
        return UserGetDto.of(user);
    }
}
