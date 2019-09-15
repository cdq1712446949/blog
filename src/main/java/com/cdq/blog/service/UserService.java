package com.cdq.blog.service;

import com.cdq.blog.dto.UserExecution;
import com.cdq.blog.model.ThumbsCollection;
import com.cdq.blog.model.User;

public interface UserService {

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    UserExecution login(User user);

    /**
     * 根据userId获取用户信息（博客数量等）
     * @param user
     * @return
     */
    UserExecution getUerInfo(User user);

    /**
     * 获取登录用户对当前文章的点赞和收藏状态
     * @param thumbsCollection
     * @return
     */
    UserExecution getThumbsCollection(ThumbsCollection thumbsCollection);

}
