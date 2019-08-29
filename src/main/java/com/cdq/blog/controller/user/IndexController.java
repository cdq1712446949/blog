package com.cdq.blog.controller.user;

import com.cdq.blog.dto.AdvertisementExecution;
import com.cdq.blog.dto.ArticleTypeExecution;
import com.cdq.blog.dto.NoticeExecution;
import com.cdq.blog.model.Notice;
import com.cdq.blog.service.AdvertisementService;
import com.cdq.blog.service.ArticleTypeService;
import com.cdq.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private AdvertisementService advertisementService;

    /**
     *轮播图广告列表（限制轮播图数量不超过8张,使用缓存）
     * @return
     */
    @RequestMapping(value = "/advertismentlist",method = RequestMethod.GET)
    public Map<String,Object> getAdvertismentList(){
        Map<String,Object> modelMap=new HashMap<>();
        //TODO 前端获取参数
        AdvertisementExecution advertisementExecution=advertisementService.getAdvertisementListUser();
        if (advertisementExecution.getState()==0){
            modelMap.put("success",true);
            modelMap.put("advertisementList",advertisementExecution.getAdvertisementList());
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg",advertisementExecution.getStateInfo());
        }
        return modelMap;
    }

    /**
     * 返回公告列表(一般两三条就可以)
     * @return
     */
    @RequestMapping(value = "/noticelist",method = RequestMethod.GET)
    public Map<String,Object> getNoticeList(){
        Map<String,Object> modelMap=new HashMap<>();
        //TODO 前端获取参数
        Notice notice=new Notice();
        notice.setNoticeStatus((byte) 0);
        NoticeExecution noticeExecution=noticeService.getNoticeList(notice,1,1);
        if (noticeExecution.getState()==0){
            modelMap.put("success",true);
            modelMap.put("noticeList",noticeExecution.getNoticeList());
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg",noticeExecution.getStateInfo());
        }
        return modelMap;
    }

    /**
     * 获取文章类型列表(按照权重排序，使用缓存)
     * @return
     */
    @RequestMapping(value = "/firstarticletypelist",method = RequestMethod.GET)
    public Map<String,Object> getFirstArticleTypeList(){
        Map<String,Object> modelMap=new HashMap<>();
        ArticleTypeExecution articleTypeExecution=articleTypeService.getFirstArticleTypeList();
        modelMap.put("success",true);
        modelMap.put("firstArticleTypeList",articleTypeExecution.getArticleTypeList());
        return modelMap;
    }

}
