package com.cdq.blog.dao;

import com.cdq.blog.model.ThumbsCollection;
import com.cdq.blog.model.User;
import com.cdq.blog.model.UserInfo;
import org.springframework.stereotype.Component;

@Component("userDao")
public interface UserDao {

    /**
     * 用户登录查询
     * @param user
     * @return
     */
    User queryUserByUserName(User user);

    /**
     * 获取用户信息(blog_num,funs_num,look_num,comment_num)
     * js计算等级,
     * @param user
     * @return
     */
    UserInfo queryUserInfo(User user);

    /**
     * 根据用户id和articleId查询该用户是否点赞或者收藏了该文章
     * @param thumbsCollection
     * @return
     */
    ThumbsCollection queryThumbsCollection(ThumbsCollection thumbsCollection);

}
