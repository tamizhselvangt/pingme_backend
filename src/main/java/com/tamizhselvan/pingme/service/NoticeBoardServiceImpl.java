package com.tamizhselvan.pingme.service;


import com.tamizhselvan.pingme.models.NoticeBoard;
import com.tamizhselvan.pingme.repository.NoticeBoardDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService {

    @Autowired
    NoticeBoardDao noticeDao;

    @Override
    public NoticeBoard postNotice (NoticeBoard notice) {
        return noticeDao.save(notice);
    }

    @Override
    public NoticeBoard getNotice (Long id) {
        return noticeDao.getById(id);
    }

    @Override
    public List<NoticeBoard> getAllNotices () {
        return noticeDao.findAll();
    }


}
