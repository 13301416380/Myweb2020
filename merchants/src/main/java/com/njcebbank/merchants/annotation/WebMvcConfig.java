package com.njcebbank.merchants.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author：不许人间见白头 Time：2020/12/4 10:10
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private UserRolesInterceptor userRolesInterceptor;
    /**
     * 配置注解拦截器
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(userRolesInterceptor);
        registration.addPathPatterns("/**");                      //所有路径都被拦截
//        registration.excludePathPatterns(                         //添加不拦截路径
//                "你的登陆路径",            //登录
//                "/**/*.html",            //html静态资源
//                "/**/*.js",              //js静态资源
//                "/**/*.css",             //css静态资源
//                "/**/*.woff",
//                "/**/*.ttf"
//        );
    }
}
