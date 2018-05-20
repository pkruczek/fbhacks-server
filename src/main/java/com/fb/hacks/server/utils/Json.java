package com.fb.hacks.server.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Json {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    public static <T> T deserialize(String json, Class<T> klass) {
        return MAPPER.readValue(json, klass);
    }

    @SneakyThrows
    public static <T> T deserialize(String json, TypeReference<T> typeReference) {
        return MAPPER.readValue(json, typeReference);
    }

}
