package com.tamizhselvan.pingme.controller;

import com.tamizhselvan.pingme.models.ChatRoom;
import com.tamizhselvan.pingme.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    @Autowired
    ChatRoomService chatRoomService;

    @PostMapping
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody ChatRoom chatRoom) {
        return ResponseEntity.ok(chatRoomService.createChatRoom(chatRoom));
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<ChatRoom> getChatRoom(@PathVariable Long chatId) {
        return chatRoomService.findByChatId(chatId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}