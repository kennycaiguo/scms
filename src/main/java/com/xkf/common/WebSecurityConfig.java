package com.xkf.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录配置 博客出处：http://www.cnblogs.com/GoodHelper/p/6343190.html
 *
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user_login";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    /**
     * 如果没有登录的跳转
     */
    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {

            request.setCharacterEncoding("UTF-8");
            StringBuffer requestURL = request.getRequestURL();

//            // 后台管理页面没有登录跳到登录页
//            if (requestURL.toString().contains("/admin")&&!requestURL.toString().contains("admin/login")) {
//                Object user = request.getSession().getAttribute(SESSION_KEY);
//                if (user == null) {
//                    response.sendRedirect("/admin/login");
//                    return false;
//                } else {
//                    return true;
//                }
//            }else{
//                return true;
//            }
            return true;

//            HttpSession session = request.getSession();
//            if (session.getAttribute(SESSION_KEY) != null)
//                return true;
//
//            // 跳转登录
//            String url = "/login";
//            response.sendRedirect(url);
//            return false;
        }
    }
}
