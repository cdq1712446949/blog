package com.cdq.blog.service;

import com.cdq.blog.dto.ThumbsUpExecution;
import com.cdq.blog.model.ThumbsUp;

public interface ThumbsUpService {

    /**
     * 添加点赞记录
     * @param thumbsUp
     * @return
     */
    ThumbsUpExecution addThumbsUp(ThumbsUp thumbsUp);

    /**
     * 修改点赞记录
     * @param thumbsUp
     * @return
     */
    ThumbsUpExecution changeThumbsUp(ThumbsUp thumbsUp);

}
