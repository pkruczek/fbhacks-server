package com.fb.hacks.server.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserController {

    @GetMapping("/test")
    String getUser(){
        return "adaad";
    }
}
