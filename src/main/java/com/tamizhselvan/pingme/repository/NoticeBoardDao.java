package com.tamizhselvan.pingme.repository;

import com.tamizhselvan.pingme.models.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeBoardDao extends JpaRepository<NoticeBoard, Long> {
}
