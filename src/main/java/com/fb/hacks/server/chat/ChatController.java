package com.fb.hacks.server.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat/")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("{groupId}")
    ResponseEntity<List<MessageGetDto>> getMessages(@PathVariable String groupId){
        return new ResponseEntity<>(chatService.getMessages(groupId), HttpStatus.OK);
    }

    @PostMapping("{groupId}")
    ResponseEntity<MessageGetDto> addMessage(@RequestBody MessageSaveDto message){
        return new ResponseEntity<>(chatService.saveMessage(message), HttpStatus.CREATED);
    }

}
