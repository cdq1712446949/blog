package com.cdq.blog.service;

import com.cdq.blog.dto.UserCollectionExecution;
import com.cdq.blog.dto.UserCommentExecution;
import com.cdq.blog.model.UserCollection;

public interface UserCollectionService {

    /**
     * 用户收藏记录管理
     * @param userCollection
     * @return
     */
    UserCollectionExecution userCollectionManage(UserCollection userCollection);

}
