package com.cdq.blog.service.impl;

import com.cdq.blog.dao.ArticleDao;
import com.cdq.blog.dao.ArticleTypeDao;
import com.cdq.blog.dto.ArticleExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.service.ArticleService;
import com.cdq.blog.state.BaseStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 文章管理service层
 * 组合查询文章记录前必须设置文章状态属性值（0或者-1）
 * @author cdq
 * created on 2019.08.29
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleTypeDao articleTypeDao;

    /**
     * 组合查询文章列表
     * 1
     * @param article
     * @param pageIndex
     * @param pageSize
     * @param sortColumn
     * @param ad
     * @return
     */
    @Override
    public ArticleExecution getArticleList(Article article, int pageIndex, int pageSize,String sortColumn,String ad) {

        return null;
    }

    /**
     * 添加文章记录
     * 校验参数：userId,articleTypeId,articleTitle,articleDiscription,articleKeyWord,articleContent不能为空
     * 添加创建时间属性值
     *
     * @param article
     * @return
     */
    @Override
    @Transactional
    public ArticleExecution addArticle(Article article) {
        //校验参数
        if (article.getUser().getUserId() == null || article.getUser().getUserId() == 0) {
            return new ArticleExecution(BaseStateEnum.EMPTY_USER);
        }
        ArticleType articleType = new ArticleType();
        articleType.setArticleTypeId(article.getArticleType().getArticleTypeId());
        if (articleTypeDao.queryArticleTypeById(articleType).getParentArticleType().getArticleTypeId() == null) {
            return new ArticleExecution(BaseStateEnum.ILLEGAL_PARAMETER);
        }
        if (article.getArticleKeyWord() == null || article.getArticleKeyWord().equals("")) {
            return new ArticleExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (article.getArticleDiscription() == null || article.getArticleDiscription().equals("")) {
            return new ArticleExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (article.getArticleContent() == null || article.getArticleContent().equals("")) {
            return new ArticleExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (article.getArticleTitle() == null || article.getArticleTitle().equals("")) {
            return new ArticleExecution(BaseStateEnum.EMPTY_INFO);
        }
        //添加创建时间属性值
        article.setArticleCreateTime(new Date());
        //向数据库添加纪录
        try {
            int result = articleDao.insertArticle(article);
            if (result == 1) {
                return new ArticleExecution(BaseStateEnum.SUCCESS);
            } else {
                return new ArticleExecution(BaseStateEnum.INNER_ERROR);
            }
        } catch (Exception e) {
            throw new RuntimeException("添加文章记录时出错，错误信息：" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticleExecution changeArticle(Article article) {
        return null;
    }

    /**
     * 修改文章状态，
     * 如果放在changeArticle方法中，每次执行修改文章状态都会执行大量代码,所以分离出该方法
     *
     * @param article
     * @return
     */
    @Override
    @Transactional
    public ArticleExecution changeArticleStatus(Article article) {
        //校验参数：文章id，文章状态
        if (article.getArticleId() == null || article.getArticleId() == 0) {
            return new ArticleExecution(BaseStateEnum.EMPTY_ID);
        }
        if (article.getArticleStatus() != 0 && article.getArticleStatus() != -1) {
            return new ArticleExecution(BaseStateEnum.ILLEGAL_PARAMETER);
        }
        //请求数据库，修改文章状态数据
        try {
            int result = articleDao.updateArticleStatus(article);
            if (result == 1) {
                return new ArticleExecution(BaseStateEnum.SUCCESS);
            } else {
                return new ArticleExecution(BaseStateEnum.INNER_ERROR);
            }
        } catch (Exception e) {
            throw new RuntimeException("修改文章状态时出错，错误信息：" + e.getMessage());
        }
    }

    /**
     * 通过id获取文章记录
     * @param article
     * @return
     */
    @Override
    public ArticleExecution getArticleById(Article article) {
        //校验参数
        if (article.getArticleId() == 0 || article.getArticleId() == null) {
            return new ArticleExecution(BaseStateEnum.EMPTY_ID);
        }
        //请求数据库，获取数据
        try {
            Article article1 = articleDao.queryArticleById(article);
            return new ArticleExecution(BaseStateEnum.SUCCESS, article1);
        } catch (Exception e) {
            return new ArticleExecution(BaseStateEnum.OBJECT_ISNULL);
        }
    }
}
