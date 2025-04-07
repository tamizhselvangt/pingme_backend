package com.tamizhselvan.pingme.controller;

import com.tamizhselvan.pingme.models.NoticeBoard;
import com.tamizhselvan.pingme.service.NoticeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {
    @Autowired
    NoticeBoardService noticeService;

    @PostMapping
    public ResponseEntity<NoticeBoard> postNotice(@RequestBody NoticeBoard notice) {
        return ResponseEntity.ok(noticeService.postNotice(notice));
    }

    @PostMapping("/get/{noticeId}")
    public ResponseEntity<NoticeBoard> get(@PathVariable Long noticeId) {
        return ResponseEntity.ok(noticeService.getNotice(noticeId));
    }


    @PostMapping("/all")
    public ResponseEntity<List<NoticeBoard>> getAll() {
        return ResponseEntity.ok(noticeService.getAllNotices());
    }

}
