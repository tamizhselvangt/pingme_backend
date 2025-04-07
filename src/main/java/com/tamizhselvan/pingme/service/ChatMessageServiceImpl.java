package com.tamizhselvan.pingme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tamizhselvan.pingme.models.ChatMessage;
//import com.tamizhselvan.pingme.repository.ChatMessageDao;
import com.tamizhselvan.pingme.models.ChatMessage;
import com.tamizhselvan.pingme.repository.ChatMessageDao;
import com.tamizhselvan.pingme.utils.KafkaMessageListener;
import com.tamizhselvan.pingme.utils.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageDao chatMessageDao;

    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    public ChatMessage saveMessage(ChatMessage message) throws JsonProcessingException {

        ChatMessage savedMessage = chatMessageDao.save(message);
        String jsonPayload = new ObjectMapper().writeValueAsString(savedMessage); // serialize to JSON
        kafkaMessageProducer.sendMessage("chat-message", jsonPayload);
        return chatMessageDao.save(message);
    }



    public List<ChatMessage> findByChatId(Long chatId) {
        return chatMessageDao.findAllById(chatId);
    }
}