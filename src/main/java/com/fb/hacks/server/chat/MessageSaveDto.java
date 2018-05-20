package com.fb.hacks.server.chat;

import com.fb.hacks.server.user.UserGetDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageSaveDto {
    private final String groupId;
    private final String userId;
    private final String content;

    Message asMessage(UserGetDto user) {
        return Message.builder()
                .groupId(groupId)
                .content(content)
                .user(user)
                .build();
    }
}
