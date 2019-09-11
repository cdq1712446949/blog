package com.cdq.blog.service;

import com.cdq.blog.dto.UserCommentExecution;
import com.cdq.blog.model.UserComment;

/**
 * 用户评论service接口
 * @author cdq
 * created on 2019.9.11
 */
public interface UserCommentService {

    /**
     * 获取用户评论列表
     * @param userComment 为article.articleId赋值
     * @return 结果
     */
    UserCommentExecution getUserCommentList(UserComment userComment,int pageIndex,int pageSize);

}
