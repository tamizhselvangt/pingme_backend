package com.tamizhselvan.pingme.service;

import com.tamizhselvan.pingme.models.ChatRoom;
//import com.tamizhselvan.pingme.repository.ChatRoomDao;
import com.tamizhselvan.pingme.repository.ChatRoomDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomDao chatRoomDao;

    @Override
    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomDao.save(chatRoom);
    }

    @Override
    public Optional<ChatRoom> findByChatId(Long chatId) {
        return chatRoomDao.findById(chatId);
    }
}

