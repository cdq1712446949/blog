package com.cdq.blog.controller.user;

import com.cdq.blog.dto.ArticleTypeExecution;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    /**
     * 根据父类id获取文章类型列表
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/getarticletypelist" , method = RequestMethod.GET)
    public Map<String,Object> getArticleTypeList(int parentId){
        Map<String,Object> modelMap=new HashMap<>();
        //参数处理
        ArticleType articleType=new ArticleType();
        ArticleType parentArticleType=new ArticleType();
        parentArticleType.setArticleTypeId((short) parentId);
        articleType.setParentArticleType(parentArticleType);
        //service层调用
        try{
            ArticleTypeExecution articleTypeExecution = articleTypeService.getArticleTypeList(articleType,1,10);
            if (articleTypeExecution.getState()==0){
                modelMap.put("success",true);
                modelMap.put("articleTypeList",articleTypeExecution.getArticleTypeList());
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg",articleTypeExecution.getStateInfo());
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

}
