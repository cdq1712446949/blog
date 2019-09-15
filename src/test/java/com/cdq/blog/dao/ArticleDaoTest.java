package com.cdq.blog.dao;

import com.cdq.blog.BaseTest;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.model.User;
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
        article.setArticleKeyWord("MySQL");
        ArticleType articleType=new ArticleType();
        articleType.setArticleTypeId((short) 12);
        article.setArticleType(articleType);
        article.setArticleStatus((byte) 0);
        List<Article> articles=articleDao.queryArticleList(article,
                0,0,"good_num+look_num","desc");
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
        User user=new User();
        user.setUserId(3);
        article.setUser(user);
        ArticleType articleType=new ArticleType();
        articleType.setArticleTypeId((short) 11);
        article.setArticleType(articleType);
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

    @Test
    public void testQueryArticleById(){
        Article article=new Article();
        article.setArticleId(2);
        Article article1=articleDao.queryArticleById(article);
        Date createTime=article1.getArticleCreateTime();
        System.out.println(article1.toString());
    }

    @Test
    public void testQueryNewArticleList(){
        Article article=new Article();
        User user=new User();
        user.setUserId(3);
        article.setUser(user);
        List<Article> list=articleDao.queryNewArticleByUserId(article);
        for (Article article1:list){
            System.out.println(article1.getArticleTitle());
        }
    }

}
