package com.cdq.blog.controller.user;

import com.cdq.blog.dto.UserCollectionExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.User;
import com.cdq.blog.model.UserCollection;
import com.cdq.blog.service.UserCollectionService;
import com.cdq.blog.unit.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CollectionController {

    @Autowired
    private UserCollectionService userCollectionService;

    @RequestMapping(value = "/usercollectionmanage", method = RequestMethod.GET)
    public Map<String, Object> userCollectionManage(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        //参数处理
        int userId=HttpServletRequestUtil.getInt(request,"userId");
        int articleId=HttpServletRequestUtil.getInt(request,"articleId");
        Byte status=HttpServletRequestUtil.getByte(request,"status");
        UserCollection userCollection=new UserCollection();
        User user=new User();
        Article article=new Article();
        user.setUserId(userId);
        article.setArticleId(articleId);
        userCollection.setArticle(article);
        userCollection.setUser(user);
        userCollection.setCollectionStatus(status);
        //调用service接口
        try {
            UserCollectionExecution userCollectionExecution=userCollectionService.userCollectionManage(userCollection);
            if (userCollectionExecution.getState()==0){
                modelMap.put("success",true);
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg",userCollectionExecution.getStateInfo());
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg","请确认操作是否合理");
        }
        return modelMap;
    }

}
