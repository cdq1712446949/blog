package com.cdq.blog.service.impl;

import com.cdq.blog.BaseTest;
import com.cdq.blog.dto.ArticleExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.model.User;
import com.cdq.blog.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceTest extends BaseTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testGetArticleList(){
        Article article=new Article();
        ArticleType articleType=new ArticleType();
        articleType.setArticleTypeId((short) 11);
        article.setArticleType(articleType);
        article.setArticleStatus((byte) 0);
        ArticleExecution articleExecution=articleService.getArticleList(article,0,5,
                "good_num+look_num","desc");
        System.out.println(articleExecution.getStateInfo());
    }

    //userId,articleTypeId,articleTitle,articleDiscription,articleKeyWord,articleContent不能为空
    @Test
    public void testAddArticle(){
        Article article=new Article();
        User user=new User();
        ArticleType articleType=new ArticleType();
        user.setUserId(3);
        articleType.setArticleTypeId((short) 11);
        article.setUser(user);
        article.setArticleType(articleType);
        article.setArticleTitle("service层测试");
        article.setArticleDiscription("service层测试");
        article.setArticleContent("service层测试");
        article.setArticleKeyWord("service层测试");
        ArticleExecution articleExecution=articleService.addArticle(article);
        System.out.println(articleExecution.getStateInfo());
    }

    @Test
    public void testChangeArticle(){
        Article article=new Article();
        article.setArticleId(4);
        article.setArticleContent("测试");
        User user=new User();
        user.setUserId(3);
        article.setUser(user);
        ArticleExecution articleExecution=articleService.changeArticle(article);
        System.out.println(articleExecution.getStateInfo());
    }

    @Test
    public void testChangeArticleStatus(){
        Article article=new Article();
        article.setArticleId(4);
        article.setArticleStatus((byte) -1);
        ArticleExecution articleExecution=articleService.changeArticleStatus(article);
        System.out.println(article);
    }
    @Test
    public void testGetArticleById(){
        Article article=new Article();
        article.setArticleId(3);
        ArticleExecution articleExecution=articleService.getArticleById(article);
        System.out.println(articleExecution.getStateInfo());
    }

    @Test
    public void testQueryNewArticleList(){
        Article article=new Article();
        User user=new User();
        user.setUserId(3);
        article.setUser(user);
        ArticleExecution articleExecution=articleService.getNewArticleByUserId(article);
        System.out.println(articleExecution.getStateInfo());
    }

}
