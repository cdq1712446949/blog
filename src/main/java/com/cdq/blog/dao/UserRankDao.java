package com.cdq.blog.dao;

import com.cdq.blog.model.UserRank;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：ヅてＤＱ
 * @date ：Created in 2019/9/26 22:37
 * @description：用户权限dao层接口
 * @modified By：
 * @version: $
 */

@Component
public interface UserRankDao {

    /**
     * 获取所有用户权限记录（使用缓存）
     * @param userRank
     * @return
     */
    List<UserRank> selectAllUserRank(UserRank userRank);

}
