package com.cdq.blog.controller.user;

import com.cdq.blog.dto.UserCommentExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.UserComment;
import com.cdq.blog.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserCommentController {

    @Autowired
    private UserCommentService userCommentService;

    /**
     * 根据文章id获取评论列表
     * 使用参数注入
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getcommentsbyarticle" , method = RequestMethod.GET)
    public Map<String,Object> getCommentsByArticle(int articleId,int page){
        Map<String,Object> modelMap=new HashMap<>();
        //TODO 检查参数是否合法(articleId)
        UserComment userComment=new UserComment();
        Article article=new Article();
        article.setArticleId(articleId);
        userComment.setArticle(article);
        //调用service层接口获取数据
        //TODO 暂时按照每页十条获取，后期想起来就改
        UserCommentExecution userCommentExecution=userCommentService.getUserCommentList(userComment,page,10);
        if (userCommentExecution.getState()==0){
            modelMap.put("success",true);
            modelMap.put("userCommentList",userCommentExecution.getUserCommentList());
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg",userCommentExecution.getStateInfo());
        }
        return modelMap;
    }

}
