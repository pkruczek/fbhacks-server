package com.fb.hacks.server.provider.facebook;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FacebookDataProvider implements IntegratedServiceDataProvider {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @Autowired
    public FacebookDataProvider(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @Override
    public Set<String> getRawInterests(String userId) {
        PagedList<Page> pagesLiked = facebook.likeOperations().getPagesLiked();
        return pagesLiked.stream()
                .map(Page::getDescription)
                .collect(Collectors.toSet());
    }

}
