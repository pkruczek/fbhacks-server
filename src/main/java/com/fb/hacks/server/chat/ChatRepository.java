package com.fb.hacks.server.chat;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends MongoRepository<Message, ObjectId> {

    List<Message> findByGroupIdOrderByIdAsc(String groupId);
}
