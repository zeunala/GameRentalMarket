package com.zeunala.gamerental.interceptor;

import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    /**
     * 모든 사용자의 요청에 대하여 로그를 남긴다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionName.LOGIN_USERS_ID) == null) {
            log.info("Guest Users request: {}", request.getRequestURI());
            return true;
        }
        log.info("Users {} request: {}", session.getAttribute(SessionName.LOGIN_USERS_ID), request.getRequestURI());
        return true;
    }
}
