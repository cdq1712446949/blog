package com.cdq.blog.service.impl;

import com.cdq.blog.dto.NoticeExecution;
import com.cdq.blog.model.Notice;
import com.cdq.blog.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceTest {

    @Autowired
    private NoticeService noticeService;

    @Test
    public void testQueryNoticeList() {
        Notice notice = new Notice();
        notice.setNoticeStatus((byte) 0);
        NoticeExecution noticeExecution = noticeService.getNoticeList(notice,0,5);
    }

    @Test
    public void testAddNotice() {
        Notice notice = new Notice();
        notice.setNoticeContent("service层测试");
        NoticeExecution noticeExecution = noticeService.addNotice(notice);
    }

    @Test
    public void testChangeNotice() {
        Notice notice = new Notice();
        notice.setNoticeId((short) 2);
        notice.setNoticeStatus((byte) -1);
        NoticeExecution noticeExecution = noticeService.changeNotice(notice);
    }

}
