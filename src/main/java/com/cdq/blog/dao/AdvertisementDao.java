package com.cdq.blog.dao;

import com.cdq.blog.model.Advertisement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("advertismentDao")
public interface AdvertisementDao {

    /**
     * 查询广告列表
     * 根据参数属性值组合查询
     * 用户查询:获取状态值为0的广告
     * 管理员查询：可以获取所有广告记录，根据name字段模糊查询
     * @param advertisement
     * @return
     */
    List<Advertisement> queryAdvertisement(@Param("advertisement") Advertisement advertisement,@Param("rowIndex")int page,
                                           @Param("pageSize")int pageSize);

    /**
     * 添加广告记录
     * 管理才可以添加广告记录（设置权限拦截器）
     * @param advertisement
     * @return
     */
    int insertAdvertisement(@Param("advertisement")Advertisement advertisement);

    /**
     * 修改广告记录
     * 需要管理员权限
     * @param advertisement
     * @return
     */
    int updateAdvertisement(Advertisement advertisement);

}
