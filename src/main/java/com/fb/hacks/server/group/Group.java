package com.fb.hacks.server.group;

import com.fb.hacks.server.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@Wither
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
public class Group {
    @Id
    private final String id;
    private final Set<String> interests;
    private final Set<User> members;
}
