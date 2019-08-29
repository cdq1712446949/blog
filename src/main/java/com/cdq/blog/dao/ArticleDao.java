package com.cdq.blog.dao;

import com.cdq.blog.model.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("articleDao")
public interface ArticleDao {

    /**
     * 获取文章列表
     * 根据title,discription模糊查询
     * 根据id查询，id查询不在组合查询内
     * 根据作者查询
     * @param article
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Article> queryArticleList(@Param("article")Article article,
                                   @Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);

    /**
     * 添加文章记录
     * @param article
     * @return
     */
    int insertArticle(Article article);

    /**
     * 修改文章记录
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 修改文章状态
     * @param article
     * @return
     */
    int updateArticleStatus(Article article);

}
