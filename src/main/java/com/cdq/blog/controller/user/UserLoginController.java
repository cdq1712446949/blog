package com.cdq.blog.controller.user;

import com.cdq.blog.dto.UserExecution;
import com.cdq.blog.model.User;
import com.cdq.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserLoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录方法
     * 一个用户浏览器只能创建一个session，只能登录一个账号
     * @param request
     * @return
     */
    @RequestMapping(value = "/userlogin" , method = RequestMethod.POST)
    public Map<String,Object> userLogin(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<>();
//        Cookie[] cookes=request.getCookies();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User();
        user.setUserName(username);
        user.setPassWord(password);
        UserExecution result=userService.login(user);
        if (result.getState()==0){
            modelMap.put("success",true);
            modelMap.put("userInfo",result.getUser());
//            request.getSession().setAttribute("cdq_blog_user_info",result.getUser().getUserName());
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg",result.getStateInfo());
        }
        return modelMap;
    }

}
