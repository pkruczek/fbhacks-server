package com.fb.hacks.server.user;

import lombok.*;
import lombok.experimental.Wither;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private final String name;
    private final String lastName;

}



