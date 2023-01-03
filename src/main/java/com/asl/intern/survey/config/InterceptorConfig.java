package com.asl.intern.survey.config;

import com.asl.intern.survey.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")//拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns("/survey-api/admin","/survey-api/survey","survey-api/records");
    }

    @Bean
    public JwtUtil jwtInterceptor() {
        return new JwtUtil();
    }
}
