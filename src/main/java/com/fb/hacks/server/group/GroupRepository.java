package com.fb.hacks.server.group;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, ObjectId> {
}
