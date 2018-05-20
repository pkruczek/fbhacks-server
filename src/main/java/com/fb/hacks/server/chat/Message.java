package com.fb.hacks.server.chat;

import com.fb.hacks.server.user.UserGetDto;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Message {
    @Id
    private final ObjectId id;
    @Indexed
    private final String groupId;
    private final UserGetDto user;
    private final String content;
}
