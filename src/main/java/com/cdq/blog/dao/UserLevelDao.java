package com.cdq.blog.dao;

import com.cdq.blog.model.UserLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户等级dao层
 * @author cdq
 * created on 2019.08.22
 */
@Component("userLevelDao")
public interface UserLevelDao {

    /**
     * 获取用户等级规则列表
     * @return
     */
    List<UserLevel> queryUserLevelList(@Param("rowIndex")int page, @Param("pageSize")int pageSize);

    /**
     * 通过id更新用户等级（清除缓存）
     * @param userLevel
     * @return
     */
    int updateUserLevelById(@Param("userLevel") UserLevel userLevel);

}
