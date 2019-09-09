package com.cdq.blog.dao;

import com.cdq.blog.BaseTest;
import com.cdq.blog.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryUserByUserName(){
        User user=new User();
        user.setUserName("admin");
        user.setPassWord("admn");
        User u=userDao.queryUserByUserName(user);
//        System.out.println(u.getNickName());
    }

}
