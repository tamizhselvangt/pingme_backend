package com.tamizhselvan.pingme.service;

import com.tamizhselvan.pingme.models.NoticeBoard;

import java.util.List;
import java.util.UUID;

public interface NoticeBoardService {

    public NoticeBoard postNotice(NoticeBoard notice);

    public NoticeBoard getNotice(Long id);

    public List<NoticeBoard> getAllNotices();
}

