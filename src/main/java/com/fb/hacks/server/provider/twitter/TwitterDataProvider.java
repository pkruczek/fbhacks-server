package com.fb.hacks.server.provider.twitter;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TwitterDataProvider implements IntegratedServiceDataProvider {

    private static final Twitter TWITTER = TwitterFactory.getSingleton();

    @Override
    public Set<String> getRawInterests(String userId) {
        return getTweets(userId);
    }

    @SneakyThrows
    private Set<String> getTweets(String userId) {
        return favourites(userId).stream()
                .map(Status::getText)
                .collect(Collectors.toSet());
    }

    @SneakyThrows
    private ResponseList<Status> favourites(String username) {
        return TWITTER.favorites().getFavorites(username);
    }

}
