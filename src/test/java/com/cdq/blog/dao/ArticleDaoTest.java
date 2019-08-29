package com.cdq.blog.dao;

import com.cdq.blog.BaseTest;
import com.cdq.blog.model.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ArticleDaoTest extends BaseTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void testQueryArticleList(){
        Article article=new Article();
        article.setArticleTitle("MySQL");
        List<Article> articles=articleDao.queryArticleList(article,0,0);
        System.out.println(String.valueOf(articles.size()));
    }

    @Test
    public void testInsertArticle(){
        Article article=new Article();
        article.setArticleTitle("测试");
        article.setArticleKeyWord("测试");
        article.setArticleContent("测试");
        article.setArticleCreateTime(new Date());
        article.setArticleDiscription("测试");
        article.setUserId(3);
        article.setArticleTypeId((short) 11);
        int result=articleDao.insertArticle(article);
        System.out.println(String.valueOf(result));
    }

    @Test
    public void testChangeArticle(){
        Article article=new Article();
        article.setArticleTitle("dao层测试");
        article.setArticleId(3);
        int result=articleDao.updateArticle(article);
    }

    @Test
    public void testUpdateArticleStatus(){
        Article article=new Article();
//        article.setArticleTitle("dao层测试");
        article.setArticleId(3);
        article.setArticleStatus((byte) -1);
        int result=articleDao.updateArticleStatus(article);
        System.out.println(String.valueOf(result));
    }

}
