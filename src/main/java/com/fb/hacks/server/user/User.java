package com.fb.hacks.server.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@Wither
@Builder
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    private final ObjectId id;

    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final Set<String> interests;
}




