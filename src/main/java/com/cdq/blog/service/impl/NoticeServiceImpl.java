package com.cdq.blog.service.impl;

import com.cdq.blog.dao.NoticeDao;
import com.cdq.blog.dto.NoticeExecution;
import com.cdq.blog.model.Notice;
import com.cdq.blog.service.NoticeService;
import com.cdq.blog.state.NoticeStateEnum;
import com.cdq.blog.unit.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl  implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public NoticeExecution getNoticeList(Notice notice,int page,int pageSize) {
        List<Notice> list=noticeDao.queryNoticeList(notice,PageUtil.pageToRowIndex(page,pageSize),pageSize);
        return new NoticeExecution(NoticeStateEnum.SUCCESS,list);
    }

    /**
     * 添加公告（内容不能为空）
     * @param notice
     * @return
     */
    @Override
    @Transactional
    public NoticeExecution addNotice(Notice notice) {
        //参数校验
        if (notice.getNoticeContent().equals("")||notice.getNoticeContent()==null){
            return new NoticeExecution(NoticeStateEnum.EMPTY_CONTENT);
        }
        //添加创建时间属性值
        notice.setNoticeCreateTime(new Date());
        //添加数据库记录
        try {
            int result=noticeDao.insertNotice(notice);
            if (result>0){
                return new NoticeExecution(NoticeStateEnum.SUCCESS);
            }else {
                return new NoticeExecution(NoticeStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("添加notice记录失败，错误信息："+e.getMessage());
        }
    }

    /**
     * 修改公告记录
     * id，创建时间不可更改
     * @param notice
     * @return
     */
    @Override
    @Transactional
    public NoticeExecution changeNotice(Notice notice) {
        //校验参数
        if (notice.getNoticeId()==null||notice.getNoticeId()==0){
            return new NoticeExecution(NoticeStateEnum.EMPTY_ID);
        }
        //添加最后修改时间属性值
        notice.setNoticeLastEditTime(new Date());
        //修改数据库记录
        try {
            int result=noticeDao.updateNotice(notice);
            if (result>0){
                return new NoticeExecution(NoticeStateEnum.SUCCESS);
            }else {
                return new NoticeExecution(NoticeStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("修改notice数据库记录失败，错误信息："+e.getMessage());
        }
    }


}
