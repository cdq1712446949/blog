package com.cdq.blog.service.impl;

import com.cdq.blog.dao.AdvertisementDao;
import com.cdq.blog.dto.AdvertisementExecution;
import com.cdq.blog.model.Advertisement;
import com.cdq.blog.service.AdvertisementService;
import com.cdq.blog.state.AdvertisementStateEnum;
import com.cdq.blog.unit.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

    /**
     * 管理员调用的查询方法
     *
     * @param advertisement
     * @return
     */
    @Override
    public AdvertisementExecution getAdvertisementList(Advertisement advertisement,int page,int pageSize) {
        List<Advertisement> list = advertisementDao.queryAdvertisement(
                advertisement,PageUtil.pageToRowIndex(page,pageSize),pageSize);
        return new AdvertisementExecution(AdvertisementStateEnum.SUCCESS, list);
    }

    /**
     * 添加广告记录
     * advertisement_href，advertisement_photo，advertisement_name属性值不能为空
     *
     * @param advertisement
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "advertisementList" , allEntries = true)
    public AdvertisementExecution addAdvertisement(Advertisement advertisement) {
        //参数校验
        if (advertisement.getAdvertisementHref() != null && !advertisement.getAdvertisementHref().equals("")) {
            if (advertisement.getAdvertisementName() != null && !advertisement.getAdvertisementName().equals("")) {
                if (advertisement.getAdvertisementPhoto() != null && !advertisement.getAdvertisementPhoto().equals("")) {
                    //添加创建时间属性值
                    advertisement.setAdvertisementCreateTime(new Date());
                    //请求数据库添加纪录
                    try {
                        int result=advertisementDao.insertAdvertisement(advertisement);
                        if (result>0){
                            return new AdvertisementExecution(AdvertisementStateEnum.SUCCESS);
                        }else {
                            return new AdvertisementExecution(AdvertisementStateEnum.INNER_ERROR);
                        }
                    }catch (Exception e){
                        throw new RuntimeException("数据库添加广告记录失败，错误信息："+e.getMessage());
                    }
                } else {
                    return new AdvertisementExecution(AdvertisementStateEnum.EMPTY_INFO);
                }
            } else {
                return new AdvertisementExecution(AdvertisementStateEnum.EMPTY_INFO);
            }
        } else {
            return new AdvertisementExecution(AdvertisementStateEnum.EMPTY_INFO);
        }
    }

    /**
     * 修改广告记录
     * id不能为空
     * @param advertisement
     * @return
     */
    @Transactional
    @Override
    @CacheEvict(value = "advertisementList" , allEntries = true)
    public AdvertisementExecution changeAdvertisement(Advertisement advertisement) {
        //校验参数
        if (advertisement.getAdvertisementId()==null||advertisement.getAdvertisementId()==0){
            return new AdvertisementExecution(AdvertisementStateEnum.EMPTY_ID);
        }
        //添加最后修改时间属性值
        advertisement.setAdvertisementLastEditTime(new Date());
        //修改数据库记录
        try {
            int result=advertisementDao.updateAdvertisement(advertisement);
            if (result==1){
                return new AdvertisementExecution(AdvertisementStateEnum.SUCCESS);
            }else {
                return new AdvertisementExecution(AdvertisementStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("修改广告记录失败，错误信息："+e.getMessage());
        }
    }

    @Cacheable(value = "advertisementList")
    @Override
    public AdvertisementExecution getAdvertisementListUser() {
        Advertisement advertisement=new Advertisement();
        advertisement.setAdvertisementStatus((byte) 0);
        List<Advertisement> list=advertisementDao.queryAdvertisement(advertisement,0,8);
        return new AdvertisementExecution(AdvertisementStateEnum.SUCCESS,list);
    }
}
