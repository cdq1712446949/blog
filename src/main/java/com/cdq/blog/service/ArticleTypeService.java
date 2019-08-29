package com.cdq.blog.service;

import com.cdq.blog.dto.ArticleTypeExecution;
import com.cdq.blog.model.ArticleType;

/**
 * 文章类型service层
 * @author cdq
 * created on 2019.08.24
 */
public interface ArticleTypeService {

    /**
     * 根据属性的有无，组合查询文章类型列表
     * @param articleType
     * @return
     */
    ArticleTypeExecution getArticleTypeList(ArticleType articleType,int page,int pageSize);

    /**
     * 修改文章类型
     * @param articleType
     * @return
     */
    ArticleTypeExecution updateArticleType(ArticleType articleType);

    /**
     * 获取一级文章类型列表(添加缓存)
     * @return
     */
    ArticleTypeExecution getFirstArticleTypeList();

}
