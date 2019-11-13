package com.cdq.blog.event;

import com.cdq.blog.BaseTest;
import com.cdq.blog.event.publisher.DemoPublisher;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author ：ヅてＤＱ
 * @date ：Created in 2019/9/27 8:32
 * @description：事件测试
 * @modified By：
 * @version: $
 */
public class TestEvent extends BaseTest {

    @Resource
    private DemoPublisher demoPublisher;

    @Test
    public void testPublisher(){
        demoPublisher.publish(1L,"ceshi");
    }

}
