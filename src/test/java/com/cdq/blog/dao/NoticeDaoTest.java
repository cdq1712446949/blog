package com.cdq.blog.dao;

import com.cdq.blog.model.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeDaoTest {

    @Autowired
    private NoticeDao noticeDao;

    @Test
    public void testQueryNoticeList() {
        Notice notice = new Notice();
        notice.setNoticeStatus((byte) 0);
        List<Notice> list = noticeDao.queryNoticeList(notice,0,5);
    }

    @Test
    public void testInsertNotice() {
        Notice notice = new Notice();
        notice.setNoticeContent("dao曾测试");
        notice.setNoticeCreateTime(new Date());
        int result = noticeDao.insertNotice(notice);
        System.out.println(String.valueOf(result));
    }

    @Test
    public void testUpdateNotice(){
        Notice notice=new Notice();
        notice.setNoticeId((short) 1);
        notice.setNoticeContent("dao层修改测试");
        notice.setNoticeLastEditTime(new Date());
        int result=noticeDao.updateNotice(notice);
    }

}
