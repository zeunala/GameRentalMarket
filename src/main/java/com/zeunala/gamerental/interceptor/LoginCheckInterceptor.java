package com.zeunala.gamerental.interceptor;

import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 로그인 상태가 아니라면 login 페이지로 돌려보낸다.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionName.LOGIN_USERS_ID) == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
