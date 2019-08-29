package com.cdq.blog.service.impl;

import com.cdq.blog.dto.UserLevelExecution;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.model.UserLevel;
import com.cdq.blog.service.UserLevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLevelServiceTest {

    @Autowired
    private UserLevelService userLevelService;

    @Test
    public void testQueryUserLevelList(){
        List<UserLevel> list=userLevelService.getUserLevelList();
        for (UserLevel userLevel:list){
            System.out.println(userLevel.getUserLevelName());
        }
    }

    @Test
    public void testUpdateUserLevel(){
        UserLevel userLevel=new UserLevel();
        userLevel.setUserLevelId((byte) 12);
        userLevel.setUserLevelName("荣耀1");
        UserLevelExecution userLevelExecution=userLevelService.updateUserLevel(userLevel);
        System.out.println(userLevelExecution.getStatInfo());
    }

    @Test
    public void test(){
        ArticleType articleType=new ArticleType();
        System.out.println("sss");
    }

}
