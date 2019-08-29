package com.cdq.blog.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ArticleController {

    /**
     * 获取文章列表
     * 用户获取：
     * 管理员获取：
     * @return
     */
    @RequestMapping(value = "/getarticlelist",method = RequestMethod.GET)
    public Map<String,Object> getArticleList(){
        Map<String,Object> modelMap=new HashMap<>();
        return modelMap;
    }

    /**
     * 添加文章记录
     * 校验参数：
     * 2.用户id:session中获取userId
     * 3.
     * @return
     */
    @RequestMapping(value = "/addarticle" , method = RequestMethod.GET)
    public Map<String,Object> addArticle(){
        Map<String,Object> modelMap=new HashMap<>();
        return modelMap;
    }

}
