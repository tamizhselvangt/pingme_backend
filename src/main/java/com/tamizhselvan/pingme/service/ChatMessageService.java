package com.tamizhselvan.pingme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamizhselvan.pingme.models.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    public ChatMessage saveMessage(ChatMessage message) throws JsonProcessingException;

    public List<ChatMessage> findByChatId(Long chatId);
}

