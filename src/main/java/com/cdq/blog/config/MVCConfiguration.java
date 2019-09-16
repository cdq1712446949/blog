package com.cdq.blog.config;

import com.cdq.blog.interceptor.CheckLoginUserInterceptor;
import com.cdq.blog.interceptor.LoginInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 拦截器配置
 *
 * @author cdq
 * created on 2019.08.19
 */
@Configuration
//@EnableWebMvc
public class MVCConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 注册拦截器（实现HandlerInterceptor）
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/iszanorcollection","/thumbsUpManage","/usercollectionmanage");
        registry.addInterceptor(new CheckLoginUserInterceptor())
                .addPathPatterns("/iszanorcollection","/thumbsUpManage","/usercollectionmanage");
    }

    /**
     * 定义默认的请求处理器
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name = "viewResolver")
    public ViewResolver createViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setApplicationContext(this.applicationContext);
        viewResolver.setCache(false);
        viewResolver.setPrefix("/WEB-INF/html/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    /**
     * 根据路径返回视图
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("user/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/user_image/**")
                .addResourceLocations("file:D:/blogimage/user_image/");
    }


}
