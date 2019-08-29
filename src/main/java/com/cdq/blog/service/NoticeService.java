package com.cdq.blog.service;

import com.cdq.blog.dto.NoticeExecution;
import com.cdq.blog.model.Notice;

/**
 * 公告service层
 * @author cdq
 * created on 2019.08.24
 */
public interface NoticeService {

    /**
     * 获取公告列表
     * @param notice
     * @return
     */
    NoticeExecution getNoticeList(Notice notice,int page,int pageSize);

    /**
     * 添加公告
     * @param notice
     * @return
     */
    NoticeExecution addNotice(Notice notice);

    /**
     * 修改公告记录
     * @param notice
     * @return
     */
    NoticeExecution changeNotice(Notice notice);

}
