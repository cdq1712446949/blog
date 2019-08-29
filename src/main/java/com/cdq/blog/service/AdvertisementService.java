package com.cdq.blog.service;

import com.cdq.blog.dto.AdvertisementExecution;
import com.cdq.blog.model.Advertisement;

/**
 * 广告service层
 * @author cdq
 * create on 2019.08.24
 */
public interface AdvertisementService {

    /**
     * 获取广告列表
     * @param advertisement
     * @return
     */
    AdvertisementExecution getAdvertisementList(Advertisement advertisement,int page,int pageSize);

    /**
     * 添加广告(设置权限拦截器)
     * @param advertisement
     * @return
     */
    AdvertisementExecution addAdvertisement(Advertisement advertisement);

    /**
     * 修改广告（设置权限拦截器）
     * @param advertisement
     * @return
     */
    AdvertisementExecution changeAdvertisement(Advertisement advertisement);

    /**
     * 用户获取广告列表(添加缓存)
     * @return
     */
    AdvertisementExecution getAdvertisementListUser();

}
