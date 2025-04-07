package com.tamizhselvan.pingme.repository;

import com.tamizhselvan.pingme.models.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ChatRoomDao extends JpaRepository<ChatRoom, Long> {
}
