package com.cdq.blog.dao;

import com.cdq.blog.model.User;
import org.springframework.stereotype.Component;

@Component("userDao")
public interface UserDao {

    /**
     * 用户登录查询
     * @param user
     * @return
     */
    User queryUserByUserName(User user);



}
