package com.fb.hacks.server.chat;

import com.fb.hacks.server.user.UserGetDto;
import com.fb.hacks.server.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fb.hacks.server.utils.ObjectIdConverter.toObjectId;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    List<MessageGetDto> getMessages(String groupId) {
        return chatRepository.findByGroupIdOrderByIdAsc(groupId).stream()
                .map(MessageGetDto::of)
                .collect(toList());
    }

    MessageGetDto saveMessage(MessageSaveDto message) {
        UserGetDto savedUser = UserGetDto.of(
                userRepository.findOneById(toObjectId(message.getUserId()))
        );
        return MessageGetDto.of(chatRepository.save(message.asMessage(savedUser)));
    }
}
