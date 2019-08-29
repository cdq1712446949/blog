package com.cdq.blog.dao;

import com.cdq.blog.model.Advertisement;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class AdvertisementDaoTest {

    @Autowired
    private AdvertisementDao advertisementDao;

    @Test
    public void testInsert() {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementHref("测试");
        advertisement.setAdvertisementPhoto("测试");
        advertisement.setAdvertisementCreateTime(new Date());
        advertisement.setAdvertisementName("test");
        int result = advertisementDao.insertAdvertisement(advertisement);
    }

    @Test
    public void testSelect() {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementId((short) 1);
        List<Advertisement> list = advertisementDao.queryAdvertisement(advertisement,0,5);
    }

    @Test
    public void testUpdate() {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementId((short) 1);
        advertisement.setAdvertisementName("dao层测试");
        int result = advertisementDao.updateAdvertisement(advertisement);
    }

}
