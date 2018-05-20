package com.fb.hacks.server.testing;

import com.fb.hacks.server.provider.facebook.FacebookDataProvider;
import com.fb.hacks.server.provider.twitter.TwitterDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/api/")
@RestController
@RequiredArgsConstructor
public class TestingController {

    private final FacebookDataProvider facebookDataProvider;
    private final TwitterDataProvider twitterDataProvider;

    @GetMapping("likes")
    public String getLikes() {
        return facebookDataProvider.getRawInterests("test").toString();
    }

    @GetMapping("tweets")
    public String getTweets() {
        return twitterDataProvider.getRawInterests("greg").toString();
    }

    @GetMapping("fb")
    public ModelAndView getFb() {
        return new ModelAndView("redirect:/connect/facebook");
    }

}
