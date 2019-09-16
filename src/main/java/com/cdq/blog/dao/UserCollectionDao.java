package com.cdq.blog.dao;

import com.cdq.blog.model.UserCollection;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userCollcetionDao")
public interface UserCollectionDao {

    /**
     * 查询收藏记录
     * @param userCollection
     * @return
     */
    List<UserCollection> selectUserCollection(UserCollection userCollection);

    /**
     * 查重使用接口
     * @param userCollection
     * @return
     */
    UserCollection duplicateCheck(UserCollection userCollection);

    /**
     * 添加收藏记录
     * @param userCollection
     * @return
     */
    int insertUserCollection(UserCollection userCollection);

    /**
     * 修改收藏记录
     * @param userCollection
     * @return
     */
    int updateUserCollection(UserCollection userCollection);

}
