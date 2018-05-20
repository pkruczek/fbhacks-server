package com.fb.hacks.server.provider.spotify;

import com.fb.hacks.server.provider.IntegratedServiceDataProvider;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Paging;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class SpotifyDataProvider implements IntegratedServiceDataProvider {

    private final SpotifyFactory spotifyFactory;

    @Override
    @SneakyThrows
    public Set<String> getRawInterests(String userId) {
        Paging<Artist> artists = spotifyApi().getUsersTopArtists().build().execute();
        return Stream.of(artists.getItems())
                .map(Artist::getName)
                .collect(Collectors.toSet());
    }

    private SpotifyApi spotifyApi() {
        return spotifyFactory.getSpotifyApi();
    }

}
