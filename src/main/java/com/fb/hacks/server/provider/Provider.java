package com.fb.hacks.server.provider;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Wither
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor(staticName = "of")
public class Provider {
    private final ObjectId id;
}
