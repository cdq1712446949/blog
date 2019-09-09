package com.cdq.blog.controller.user;

import com.cdq.blog.dto.ArticleExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/article" , method = {RequestMethod.GET,RequestMethod.POST})
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取文章列表
     * 用户获取：
     * 管理员获取：
     * 1.查询内容赋值给keyword
     * 2.查询登陆用的的信息，普通用户设置文章状态为0，管理员不设置
     * @return
     */
    @RequestMapping(value = "/getarticlelist",method = RequestMethod.GET)
    public Map<String,Object> getArticleList(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<>();
        //TODO 后期修改为前端获取参数
        Article article=new Article();
        ArticleType articleType=new ArticleType();
//        articleType.setArticleTypeId((short) 11);
        article.setArticleType(articleType);
        article.setArticleStatus((byte) 0);
        ArticleExecution articleExecution=articleService.getArticleList(article, 0,5,
                "good_num+look_num","desc");
        if (articleExecution.getState()==0){
            modelMap.put("success",true);
            modelMap.put("articleList",articleExecution.getArticleList());
            modelMap.put("sessionId",request.getSession().getId());
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg",articleExecution.getStateInfo());
        }
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
