package com.cdq.blog.controller.user;

import com.cdq.blog.dto.ThumbsUpExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ThumbsUp;
import com.cdq.blog.model.User;
import com.cdq.blog.service.ThumbsUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cdq
 * created on 2019.9.15
 * 点赞操作数据接口
 */
@RestController
public class ThumbsUpController {

    @Autowired
    private ThumbsUpService thumbsUpService;

    /**
     * 点赞管理
     * 注册登录拦截器(点赞需要登录)
     *
     * @param userId
     * @param articleId
     * @param status
     * @return
     */
    @RequestMapping(value = "/thumbsUpManage", method = RequestMethod.GET)
    public Map<String, Object> thumbsUpManage(int userId, int articleId, Byte status) {
        Map<String, Object> modelMap = new HashMap<>();
        //前端参数处理
        ThumbsUp thumbsUp = new ThumbsUp();
        User user = new User();
        Article article = new Article();
        user.setUserId(userId);
        article.setArticleId(articleId);
        thumbsUp.setUser(user);
        thumbsUp.setArticle(article);
        thumbsUp.setUpStatus(status);
        //service层调用
        try{
            ThumbsUpExecution thumbsUpExecution = thumbsUpService.thumbsManage(thumbsUp);
            if (thumbsUpExecution.getState() == 0) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", thumbsUpExecution.getStateInfo());
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg","请确认操作是否合理");
        }
        return modelMap;
    }

}
