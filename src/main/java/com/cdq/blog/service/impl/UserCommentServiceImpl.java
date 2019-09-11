package com.cdq.blog.service.impl;

import com.cdq.blog.dao.UserCommentDao;
import com.cdq.blog.dto.UserCommentExecution;
import com.cdq.blog.model.UserComment;
import com.cdq.blog.service.UserCommentService;
import com.cdq.blog.state.UserCommentStateEnum;
import com.cdq.blog.unit.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService {

    @Autowired
    private UserCommentDao userCommentDao;

    /**
     * 获取用户评论列表
     * 1.校验参数(article.articleId)
     * @param userComment 为article.articleId赋值
     * @return
     */
    @Override
    public UserCommentExecution getUserCommentList(UserComment userComment,int pageIndex,int pageSize) {
        //校验参数
        if (userComment.getArticle()==null){
            return new UserCommentExecution(UserCommentStateEnum.EMPTY_ARTICLEID);
        }
        if (userComment.getArticle().getArticleId()==null||userComment.getArticle().getArticleId()==0){
            return new UserCommentExecution(UserCommentStateEnum.EMPTY_ARTICLEID);
        }
        //调用dao层接口获取数据
        try {
            //把页码转化为行数索引
            int rowIndex=PageUtil.pageToRowIndex(pageIndex,pageSize);
            List<UserComment> userComments=userCommentDao.queryUserCommentList(userComment,rowIndex,pageSize);
            return new UserCommentExecution(UserCommentStateEnum.SUCCESS,userComments);
        }catch (Exception e){
            return new UserCommentExecution(UserCommentStateEnum.INNER_ERROR);
        }
    }
}
