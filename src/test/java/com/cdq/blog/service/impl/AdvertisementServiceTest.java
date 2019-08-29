package com.cdq.blog.service.impl;

import com.cdq.blog.BaseTest;
import com.cdq.blog.dto.AdvertisementExecution;
import com.cdq.blog.model.Advertisement;
import com.cdq.blog.service.AdvertisementService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvertisementServiceTest extends BaseTest {

    @Autowired
    private AdvertisementService advertisementService;

    @Test
    public void testInsert() {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementHref("service测试");
        advertisement.setAdvertisementPhoto("service测试");
        advertisement.setAdvertisementName("test");
        advertisementService.addAdvertisement(advertisement);
    }

    @Test
    public void testSelect() {
        AdvertisementExecution advertisementExecution = advertisementService.getAdvertisementListUser();
    }

    @Test
    public void testUpdate() {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementId((short) 1);
        advertisement.setAdvertisementName("dao层测试");
        AdvertisementExecution advertisementExecution = advertisementService.changeAdvertisement(advertisement);
    }


}
