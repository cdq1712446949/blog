package com.cdq.blog.dao;

import com.cdq.blog.model.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import java.util.List;

@Component("articleDao")
public interface ArticleDao {

    /**
     * * 获取文章列表
     * * 根据title,discription模糊查询
     * * 根据id查询，id查询不在组合查询内
     * * 根据作者查询
     * @param article 组合查询条件
     * @param sortColumn 根据哪个字段排序
     * @param rowIndex 从第几行开始获取
     * @param pageSize 每一页记录的数量
     * @param ad 确定是升序（asc）还是降序（desc）
     * @return
     */
    //TODO 修改查询条件（articleDao.xml）
    List<Article> queryArticleList(@Param("article") Article article,  @Param("rowIndex") @Min(0) int rowIndex,
                                   @Param("pageSize") int pageSize,@Param("sortColumn") String sortColumn,
                                   @Param("ad") String ad);

    /**
     * 添加文章记录
     *
     * @param article
     * @return
     */
    int insertArticle(Article article);

    /**
     * 修改文章记录
     *
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 修改文章状态
     *
     * @param article
     * @return
     */
    int updateArticleStatus(Article article);

    /**
     * 通过id查询文章记录
     *
     * @param article
     * @return
     */
    Article queryArticleById(Article article);

    /**
     * 根据userId获取最新发布的五篇文章
     * 文章状态必须为0才可以获取
     * @param article
     * @return
     */
    List<Article> queryNewArticleByUserId(Article article);

}
