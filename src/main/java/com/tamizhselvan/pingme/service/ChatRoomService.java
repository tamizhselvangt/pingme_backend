package com.tamizhselvan.pingme.service;


import com.tamizhselvan.pingme.models.ChatRoom;

import java.util.Optional;

public interface ChatRoomService {

    public ChatRoom createChatRoom(ChatRoom chatRoom);

    public Optional<ChatRoom> findByChatId(Long chatId);
}

