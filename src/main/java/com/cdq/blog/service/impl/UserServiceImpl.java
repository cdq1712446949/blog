package com.cdq.blog.service.impl;

import com.cdq.blog.dao.UserDao;
import com.cdq.blog.dto.UserExecution;
import com.cdq.blog.model.User;
import com.cdq.blog.service.UserService;
import com.cdq.blog.state.UserStateEnum;
import com.cdq.blog.unit.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 校验参数
     * 1.username
     * 2.password
     * 获取到user后检查userStatus属性值
     * @param user
     * @return
     */
    @Override
    public UserExecution login(User user) {
        //校验参数
        if(user==null){
            return new UserExecution(UserStateEnum.EMPTY_USER);
        }
        if (user.getUserName()==null||user.getUserName().equals("")){
            return new UserExecution(UserStateEnum.EMPTY_USERNAME);
        }
        if (user.getPassWord()==null||user.getPassWord().equals("")){
            return new UserExecution(UserStateEnum.EMPTY_PASSWORD);
        }
        //密码转换为密文
        user.setPassWord(EncryptionUtil.getEncryptionStr(user.getPassWord()));
        //请求数据库获取数据
        User result=userDao.queryUserByUserName(user);
        if (result==null){
            return new UserExecution(UserStateEnum.ACCOUNT_ERROR);
        }else {
            if (result.getUserStatus()==0){
                return new UserExecution(UserStateEnum.SUCCESS,result);
            }else {
                return new UserExecution(UserStateEnum.ACCOUNT_BAN);
            }
        }
    }
}