package com.tamizhselvan.pingme.controller;

import com.tamizhselvan.pingme.models.ChatMessage;
import com.tamizhselvan.pingme.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatMessageController {

    @Autowired
    ChatMessageService chatMessageService;

    @PostMapping("/save")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessage message) throws Exception {
        message.setCreatedAt((Instant.now().getEpochSecond()));
        return ResponseEntity.ok(chatMessageService.saveMessage(message));
    }

    @GetMapping("/chat/{chatId}")
    public ResponseEntity<List<ChatMessage>> getMessagesByChatId(@PathVariable Long chatId) {
        return ResponseEntity.ok(chatMessageService.findByChatId(chatId));
    }

}