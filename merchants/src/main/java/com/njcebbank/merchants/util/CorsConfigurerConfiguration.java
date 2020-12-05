package com.njcebbank.merchants.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author：不许人间见白头 Time：2020/12/2 17:34
 */
@Configuration
public class CorsConfigurerConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                        //设置允许跨域请求的域名
                        .allowedOrigins("*")
                        //是否允许证书 不再默认开启
                        .allowCredentials(true)
                        //设置允许的方法
                        .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                        //跨域允许时间
                        .maxAge(3600);
            }
        };
    }
}
