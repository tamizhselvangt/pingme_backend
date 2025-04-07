package com.tamizhselvan.pingme.repository;

import com.tamizhselvan.pingme.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatMessageDao extends JpaRepository<ChatMessage,Long> {
    List<ChatMessage> findAllById(Long id);

}
