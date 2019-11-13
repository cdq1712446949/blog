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

    //返回博客展示页面
    @RequestMapping(value = "/blogcontent",method = RequestMethod.GET)
    public String blogContent(){
        return "user/blog";
    }

    //返回登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "user/login";
    }

    //返回注册界面
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String regist(){
        return "user/regist";
    }

    //返回跟人中心管理界面
    @RequestMapping(value = "/personinfomanage" , method = RequestMethod.GET)
    public String personInfoManage(){
        return "user/PersonInfoManage";
    }

    //返回关注管理界面
    @RequestMapping(value = "/attention" , method = RequestMethod.GET)
    public String attention(){
        return "user/attention";
    }

    //返回收藏管理界面
    @RequestMapping(value = "/collection" , method = RequestMethod.GET)
    public String collection(){
        return "user/collection";
    }

    //返回账号设置界面
    @RequestMapping(value = "/config" , method = RequestMethod.GET)
    public String config(){
        return "user/config";
    }

    //返回个人信息管理界面
    @RequestMapping(value = "/personinfo" , method = RequestMethod.GET)
    public String personInfo(){
        return "user/personinfo";
    }
}
