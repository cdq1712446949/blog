package com.cdq.blog.dao;

import com.cdq.blog.model.ArticleType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("articleTypeDao")
public interface ArticleTypeDao {

    /**
     * 查询文章类型列表
     * 1.查询一级类型列表:所有属性都是null
     * 2.父类id不能为空
     * 3.根据id获取文章类型
     * 4.其他根据情况自行决定属性内容
     * @param articleType
     * @return
     */
    List<ArticleType> queryArticleTypeList(@Param("articleType") ArticleType articleType,@Param("rowIndex")int page,
                                           @Param("pageSize")int pageSize);

    /**
     * 修改文章类型，文章类型id不能为空
     * @param articleType
     * @return
     */
    int updateArticeType(@Param("articleType")ArticleType articleType);

    /**
     * 通过id查询文章类型
     * @param articleType
     * @return
     */
    ArticleType queryArticleTypeById(ArticleType articleType);

}
