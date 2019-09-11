package com.cdq.blog.dao;

import com.cdq.blog.model.UserComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userCommentDao")
public interface UserCommentDao {

    /**
     * 根据创建时间降序排序
     * @param userComment 查询条件
     * @param rowIndex 行数索引
     * @param  pageSize 数量索引
     * @return 结果
     */
    List<UserComment> queryUserCommentList(@Param("userComment") UserComment userComment,
                                           @Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);

}
