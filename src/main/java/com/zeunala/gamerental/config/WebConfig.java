package com.zeunala.gamerental.config;

import com.zeunala.gamerental.interceptor.LogInterceptor;
import com.zeunala.gamerental.interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final LogInterceptor logInterceptor;
    private final LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/js/**", "/img/**");
        registry.addInterceptor(loginCheckInterceptor)
                .order(2)
                .addPathPatterns("/mypage/**", "/register/**", "/deal/**", "/post/**");
    }
}
