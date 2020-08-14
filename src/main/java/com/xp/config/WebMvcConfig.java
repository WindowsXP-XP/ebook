package com.xp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC 配置
 *
 * create by 2020-08-10
 * @author xp
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/user/lay/**").addResourceLocations("classpath:/layui/lay/");
//        registry.addResourceHandler("/book/lay/**").addResourceLocations("classpath:/layui/lay/");
//        registry.addResourceHandler("/lay/**").addResourceLocations("classpath:/layui/lay/");
    }
}
