package com.cdq.blog.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.cdq.blog.model.User;
import com.cdq.blog.unit.HttpServletRequestUtil;
import com.cdq.blog.unit.InterceptorUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CheckLoginUserInterceptor implements HandlerInterceptor {

    /**
     * 检查当前登录用户和请求的用户是否一致
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证当前登录用户和请求的用户是否一致
        Map<String,Object> modelMap=new HashMap<>();
        int userId=HttpServletRequestUtil.getInt(request,"userId");
        User loginUser = (User) request.getSession().getAttribute("cdq_blog_user_info");
        if (userId != loginUser.getUserId()) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "当前登陆用户和请求用户不一致");
            String jsonStr=JSONObject.toJSONString(modelMap);
            try {
                InterceptorUtil.returnJson(response,jsonStr);
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
