package com.cdq.blog.service;

import com.cdq.blog.dto.UserExecution;
import com.cdq.blog.model.User;

public interface UserService {

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    UserExecution login(User user);

}
