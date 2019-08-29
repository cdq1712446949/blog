package com.cdq.blog.service.impl;

import com.cdq.blog.dao.UserLevelDao;
import com.cdq.blog.dto.UserLevelExecution;
import com.cdq.blog.model.UserLevel;
import com.cdq.blog.service.UserLevelService;
import com.cdq.blog.state.UserLevelStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserLevelServiceImpl implements UserLevelService {

    @Autowired
    private UserLevelDao userLevelDao;

    @Cacheable(value = "userlevel")
    @Override
    public List<UserLevel> getUserLevelList() {
        return userLevelDao.queryUserLevelList(0,20);
    }

    @CacheEvict(value = "userlevel",allEntries = true)
    @Override
    @Transactional
    public UserLevelExecution updateUserLevel(UserLevel userLevel) {
        if (userLevel.getUserLevelId()<1||userLevel.getUserLevelId()>12){
            return new UserLevelExecution(UserLevelStateEnum.EMPTY_ID);
        }
        //修改数据库记录
        try {
            int result=userLevelDao.updateUserLevelById(userLevel);
            if (result>0){
                return new UserLevelExecution(UserLevelStateEnum.SUCCCESS);
            }else {
                return new UserLevelExecution(UserLevelStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("修改用户等级规则列表失败，错误信息："+e.getMessage());
        }
    }
}
