package com.fb.hacks.server.utils;

import org.bson.types.ObjectId;

public final class ObjectIdConverter {
    public static ObjectId toObjectId(String id) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Object id create problem");
        }
        return objectId;
    }

    public static String toString(ObjectId objectId) {
        return objectId.toString();
    }
}

