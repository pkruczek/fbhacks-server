package com.fb.hacks.server.api;

import com.fb.hacks.server.user.UserCreateDto;
import com.fb.hacks.server.user.UserGetDto;
import com.fb.hacks.server.user.UserLoginDto;
import com.fb.hacks.server.user.UserSaveDto;
import com.fb.hacks.server.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class UserController {
    private final UserService userService;

    @PostMapping("user")
    ResponseEntity<UserCreateDto> addUser(@RequestBody UserSaveDto userSaveDto) {
        return new ResponseEntity<UserCreateDto>(userService.createUser(userSaveDto), CREATED);
    }

    @PostMapping("login")
    ResponseEntity<UserGetDto> login(@RequestBody UserLoginDto userLoginDto) {
        return new ResponseEntity<>(userService.login(userLoginDto), OK);
    }
}
