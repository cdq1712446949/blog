package com.cdq.blog.service.impl;

import com.cdq.blog.dao.ThumbsUpDao;
import com.cdq.blog.dto.ThumbsUpExecution;
import com.cdq.blog.model.ThumbsUp;
import com.cdq.blog.service.ThumbsUpService;
import com.cdq.blog.state.BaseStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ThumbsUpServiceImpl implements ThumbsUpService {

    @Autowired
    private ThumbsUpDao thumbsUpDao;

    /**
     * 添加点赞记录
     * userId，ArticleId不能为空
     * @param thumbsUp
     * @return
     */
    @Transactional
    @Override
    public ThumbsUpExecution addThumbsUp(ThumbsUp thumbsUp) {
        //校验参数
        if (thumbsUp==null){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (thumbsUp.getArticle()==null){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (thumbsUp.getArticle().getArticleId()==null||thumbsUp.getArticle().getArticleId()==0){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (thumbsUp.getUser()==null){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (thumbsUp.getUser().getUserId()==null||thumbsUp.getUser().getUserId()==0){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        //查重，如果该记录存在返回结果
        ThumbsUp temp=thumbsUpDao.selectThumbsUp(thumbsUp);
        if (temp!=null){
            return new ThumbsUpExecution(BaseStateEnum.ILLEGAL_REQUEST);
        }
        //添加创建时间参数
        thumbsUp.setUpCreateTime(new Date());
        //请求数据库添加数据
        try {
            int result=thumbsUpDao.insertThumbsUp(thumbsUp);
            if (result==1){
                return new ThumbsUpExecution(BaseStateEnum.SUCCESS);
            }else {
                return new ThumbsUpExecution(BaseStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("添加点赞记录失败");
//            return new ThumbsUpExecution(BaseStateEnum.INNER_ERROR);
        }
    }

    /**
     * 修改点赞记录
     * @param thumbsUp
     * @return
     */
    @Override
    @Transactional
    public ThumbsUpExecution changeThumbsUp(ThumbsUp thumbsUp) {
        //校验参数
        if (thumbsUp==null){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (thumbsUp.getThumbsUpId()==0){
            return new ThumbsUpExecution(BaseStateEnum.EMPTY_INFO);
        }
        if (thumbsUp.getUpStatus()!=0&&thumbsUp.getUpStatus()!=-1){
            return new ThumbsUpExecution(BaseStateEnum.ILLEGAL_PARAMETER);
        }
        //TODO 查重
        //请求数据库修改记录
        try {
            int result=thumbsUpDao.updateThumbsUp(thumbsUp);
            if (result==1){
                return new ThumbsUpExecution(BaseStateEnum.SUCCESS);
            }else {
                return new ThumbsUpExecution(BaseStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("修改点赞记录失败:"+e.getMessage());
        }
    }
}
