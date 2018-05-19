package com.fb.hacks.server.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SwaggerController {
    @GetMapping("/")
    String redirect() {
        return "redirect:swagger-ui.html";
    }
}
