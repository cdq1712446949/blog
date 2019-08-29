package com.cdq.blog.service.impl;

import com.cdq.blog.dto.ArticleTypeExecution;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.service.ArticleTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTypeServiceTest {

    @Autowired
    private ArticleTypeService articleTypeService;

    @Test
    public void testGetArticleTypeList(){
        ArticleType articleType=new ArticleType();
        ArticleTypeExecution articleTypeExecution=articleTypeService.getArticleTypeList(articleType,0,5);
        System.out.println(articleTypeExecution.getStateInfo());
        for (ArticleType a:articleTypeExecution.getArticleTypeList()){
            System.out.println(a.getArticleTypeName());
        }
    }

    @Test
    public void testUpdateArticleTypeList(){
        ArticleType articleType=new ArticleType();
        articleType.setArticleTypeId((short) 1);
        articleType.setArticleTypeName("关注");
        ArticleTypeExecution articleTypeExecution=articleTypeService.updateArticleType(articleType);
        System.out.println(articleTypeExecution.getStateInfo());
    }

    @Test
    public void testGetFirstArticleTypeList(){
        ArticleTypeExecution articleTypeExecution=articleTypeService.getFirstArticleTypeList();
        for (ArticleType a:articleTypeExecution.getArticleTypeList()){
            System.out.println(a.getArticleTypeName());
        }
    }

}
