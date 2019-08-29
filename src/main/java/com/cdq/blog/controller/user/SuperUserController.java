package com.cdq.blog.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuperUserController {
    //返回首页界面
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "user/index";
    }

}
