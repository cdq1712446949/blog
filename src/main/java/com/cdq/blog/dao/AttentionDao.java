package com.cdq.blog.dao;

import com.cdq.blog.model.Attention;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：ヅてＤＱ
 * @date ：Created in 2019/9/27 10:39
 * @description：用户关注dao层接口
 * @modified By：
 * @version: $
 */
@Component
public interface AttentionDao {

    /**
     * 分页查询用户关注列表
     * @param attention 组合查询条件
     * @param rowIndex 起始索引
     * @param pageSize 每页数量
     * @return
     */
    List<Attention> selectAttention(@Param("attention")Attention attention,@Param("rowIndex")int rowIndex,
                                    @Param("pageSize")int pageSize);

}
