package com.fb.hacks.server.chat;

import com.fb.hacks.server.user.UserGetDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageGetDto {
    private final UserGetDto user;
    private final String content;

    static MessageGetDto of(Message message){
        return MessageGetDto.builder()
                .content(message.getContent())
                .user(message.getUser())
                .build();
    }
}
