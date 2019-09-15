package com.cdq.blog.dao;

import com.cdq.blog.BaseTest;
import com.cdq.blog.model.ThumbsCollection;
import com.cdq.blog.model.User;
import com.cdq.blog.model.UserInfo;
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

    @Test
    public void testQueryUserInfo(){
        User user=new User();
        user.setUserId(1);
        UserInfo userInfo=userDao.queryUserInfo(user);
        System.out.println(userInfo.getBlogNum());
    }

    @Test
    public void testqueryThumbsCollection(){
        ThumbsCollection thumbsCollection=new ThumbsCollection();
        thumbsCollection.setUserId(1);
        thumbsCollection.setArticleId(2);
        ThumbsCollection thumbsCollection1=userDao.queryThumbsCollection(thumbsCollection);
        System.out.println(thumbsCollection.getIsThumbsUp());
    }

}
