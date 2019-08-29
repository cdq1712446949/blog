package com.cdq.blog.service;

import com.cdq.blog.dto.UserLevelExecution;
import com.cdq.blog.model.UserLevel;

import java.util.List;

public interface UserLevelService {

    /**
     * 获取等级规则列表
     * @return
     */
    List<UserLevel> getUserLevelList();

    /**
     * 更新用户等级规则
     * @param userLevel
     * @return
     */
    UserLevelExecution updateUserLevel(UserLevel userLevel);
}
