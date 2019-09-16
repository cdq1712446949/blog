package com.cdq.blog.dao;

import com.cdq.blog.BaseTest;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.User;
import com.cdq.blog.model.UserCollection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserCollectionDaoTest extends BaseTest {

    @Autowired
    private UserCollectionDao userCollectionDao;

    @Test
    public void testSelectUserCollection(){

    }

    @Test
    public void testDuplicateCheck(){
        UserCollection userCollection=new UserCollection();
        User user=new User();
        Article article=new Article();
        user.setUserId(1);
        article.setArticleId(4);
        userCollection.setUser(user);
        userCollection.setArticle(article);
        UserCollection userCollection1=userCollectionDao.duplicateCheck(userCollection);
    }

    @Test
    public void testInsertUserCollection(){
        UserCollection userCollection=new UserCollection();
        User user=new User();
        Article article=new Article();
        user.setUserId(1);
        article.setArticleId(4);
        userCollection.setUser(user);
        userCollection.setArticle(article);
        userCollection.setCollectionCreateTime(new Date());
        int result=userCollectionDao.insertUserCollection(userCollection);
    }

    @Test
    public void testUpdateUserCollection(){
        UserCollection userCollection=new UserCollection();
        User user=new User();
        Article article=new Article();
        user.setUserId(1);
        article.setArticleId(4);
        userCollection.setUser(user);
        userCollection.setArticle(article);
        userCollection.setCollectionStatus((byte) -1);
        int result= userCollectionDao.updateUserCollection(userCollection);
    }

}
