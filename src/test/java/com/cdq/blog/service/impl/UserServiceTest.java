package com.cdq.blog.service.impl;

import com.cdq.blog.BaseTest;
import com.cdq.blog.dao.UserDao;
import com.cdq.blog.dto.UserExecution;
import com.cdq.blog.model.User;
import com.cdq.blog.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryUserByUserName(){
        User user=new User();
        user.setUserName("1712446949@qq.com");
        user.setPassWord("YWRtaW4=");
        UserExecution userExecution=userService.login(user);
        System.out.println(userExecution.getStateInfo());
    }

}
