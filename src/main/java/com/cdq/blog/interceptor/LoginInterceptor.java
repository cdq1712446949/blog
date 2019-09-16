package com.cdq.blog.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.cdq.blog.model.User;
import com.cdq.blog.unit.InterceptorUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle");
    }

    /**
     * 登录拦截器
     * 返回的错误信息需要从String转为JSON数据
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("proHandle");
        User user=(User)request.getSession().getAttribute("cdq_blog_user_info");
        if (user==null){
            Map<String,Object> modelMap=new HashMap<>();
            modelMap.put("success",false);
            modelMap.put("errMsg","请先登录");
            String jsonStr=JSONObject.toJSONString(modelMap);
            try {
                InterceptorUtil.returnJson(response,jsonStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion");
    }
}
