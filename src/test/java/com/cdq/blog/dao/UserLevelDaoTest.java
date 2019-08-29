package com.cdq.blog.dao;

import com.cdq.blog.model.UserLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLevelDaoTest {

    @Autowired
    private UserLevelDao userLevelDao;

    @Test
    public void testQueryUserLevel(){
        List<UserLevel> list=userLevelDao.queryUserLevelList(0,20);
    }

    @Test
    public void testUpdateUserLevel(){
        UserLevel userLevel=new UserLevel();
        userLevel.setUserLevelId((byte) 12);
        userLevel.setUserLevelName("荣耀巅峰");
        int result=userLevelDao.updateUserLevelById(userLevel);
        System.out.println(String.valueOf(result));
    }

}
