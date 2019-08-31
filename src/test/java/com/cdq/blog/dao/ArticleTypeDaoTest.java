package com.cdq.blog.dao;

import com.cdq.blog.model.Article;
import com.cdq.blog.model.ArticleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTypeDaoTest {

    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Test
    public void testQueryArticleTypeList(){
        ArticleType articleType=new ArticleType();
//        articleType.setArticleTypeName("J");
        ArticleType parentArticleType=new ArticleType();
        parentArticleType.setArticleTypeId((short) 7);
        articleType.setParentArticleType(parentArticleType);
        List<ArticleType> list=articleTypeDao.queryArticleTypeList(articleType,0,5);
        for (ArticleType a:list){
            System.out.println(a.getArticleTypeName());
        }
    }

    @Test
    public void testUpdateArticleType(){
        ArticleType articleType=new ArticleType();
        articleType.setArticleTypeId((short) 1);
        articleType.setArticleTypeName("关注");
        int result=articleTypeDao.updateArticeType(articleType);
        System.out.println(String.valueOf(result));
    }

    @Test
    public void testQueryArticleTypeById(){
        ArticleType articleType=new ArticleType();
        articleType.setArticleTypeId((short) 4);
        ArticleType articleType1=articleTypeDao.queryArticleTypeById(articleType);
        System.out.println(articleType1.toString());
    }

}
