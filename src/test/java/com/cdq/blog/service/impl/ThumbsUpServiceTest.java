package com.cdq.blog.service.impl;

import com.cdq.blog.BaseTest;
import com.cdq.blog.dto.ThumbsUpExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ThumbsUp;
import com.cdq.blog.model.User;
import com.cdq.blog.service.ThumbsUpService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ThumbsUpServiceTest extends BaseTest {

    @Autowired
    private ThumbsUpService thumbsUpService;

    @Test
    public void testAddThumbsUp() {
        ThumbsUp thumbsUp = new ThumbsUp();
        Article article = new Article();
        article.setArticleId(3);
        User user = new User();
        user.setUserId(1);
        thumbsUp.setArticle(article);
        thumbsUp.setUpCreateTime(new Date());
        thumbsUp.setUser(user);
        ThumbsUpExecution thumbsUpExecution = thumbsUpService.addThumbsUp(thumbsUp);
        System.out.println(thumbsUpExecution.getStateInfo());
    }

    @Test
    public void testChangeThumbsUp() {
        ThumbsUp thumbsUp = new ThumbsUp();
        thumbsUp.setUpStatus((byte) -1);
        thumbsUp.setThumbsUpId(2);
        ThumbsUpExecution thumbsUpExecution = thumbsUpService.changeThumbsUp(thumbsUp);
    }

}
