package com.fb.hacks.server.provider.facebook;

import lombok.Data;

import java.util.List;

@Data
public class LikeResponse {

    private LikeData likes;

    @Data
    public static class LikeData {
        private String name;
        private List<Like> data;
    }

    @Data
    public static class Like {
        private String name;
    }


}
