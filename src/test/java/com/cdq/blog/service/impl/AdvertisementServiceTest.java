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
        advertisement.setAdvertisementHref("http://www.baidu.com/");
        advertisement.setAdvertisementPhoto("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567850356570&di=143d5ac613b13af08e776a121761c15e&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190829%2F7e803ab02ba44d63a099e9f1e31f74f2.jpeg");
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
