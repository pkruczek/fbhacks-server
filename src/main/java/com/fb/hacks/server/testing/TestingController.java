package com.fb.hacks.server.testing;

import com.fb.hacks.server.provider.facebook.FacebookDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@RequestMapping("/api/")
@RestController
public class TestingController {

    private final FacebookDataProvider facebookDataProvider;

    @Autowired
    public TestingController(FacebookDataProvider facebookDataProvider) {
        this.facebookDataProvider = facebookDataProvider;
    }

    @GetMapping("likes")
    public String getLikes() {
        return facebookDataProvider.getRawInterests("test").toString();
    }

    @GetMapping("fb")
    public ModelAndView getFb() {
        return new ModelAndView("redirect:/connect/facebook");
    }

}
