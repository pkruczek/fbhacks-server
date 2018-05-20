package com.fb.hacks.server.provider.facebook;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import com.fb.hacks.server.utils.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FacebookDataProvider implements IntegratedServiceDataProvider {

    private final FacebookFactory facebookFactory;

    @Override
    public Set<String> getRawInterests(String userId) {
        return likeResponse().getLikes().getData()
                .stream()
                .map(LikeResponse.Like::getName)
                .collect(Collectors.toSet());
    }

    private Facebook facebook() {
        return facebookFactory.getFacebook();
    }

    private LikeResponse likeResponse() {
        String[] fields = {"likes"};
        String likesJson = facebook().fetchObject("me", String.class, fields);
        return Json.deserialize(likesJson, LikeResponse.class);
    }

}
