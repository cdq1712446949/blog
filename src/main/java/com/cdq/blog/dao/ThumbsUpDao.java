package com.cdq.blog.dao;

import com.cdq.blog.model.ThumbsUp;
import org.springframework.stereotype.Component;

@Component("thumbsUpDao")
public interface ThumbsUpDao {

    /**
     * 添加点赞记录
     * @param thumbsUp
     * @return
     */
    int insertThumbsUp(ThumbsUp thumbsUp) throws Exception;

    /**
     * 修改点赞记录
     * @param thumbsUp
     * @return
     */
    int updateThumbsUp(ThumbsUp thumbsUp);

    /**
     * 组合查询点赞记录
     * @param thumbsUp
     * @return
     */
    ThumbsUp selectThumbsUp(ThumbsUp thumbsUp);
}
