package com.cdq.blog.controller.user;

import com.cdq.blog.model.UserLevel;
import com.cdq.blog.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserLevelController {

    @Autowired
    private UserLevelService userLevelService;

    /**
     * 获取用户等级规则列表
     * @return
     */
    @RequestMapping(value = "/getuserlevellist",method = RequestMethod.GET)
    public Map<String,Object> getUserLevelList(){
        Map<String,Object> modelMap = new HashMap<>();
        List<UserLevel> userLevelList=userLevelService.getUserLevelList();
        if (userLevelList.size()>0){
            modelMap.put("success",true);
            modelMap.put("userLevelList",userLevelList);
            return modelMap;
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","获取失败");
            return modelMap;
        }
    }

}
