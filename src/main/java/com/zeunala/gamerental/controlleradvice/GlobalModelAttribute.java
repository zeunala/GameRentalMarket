package com.zeunala.gamerental.controlleradvice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 모든 컨트롤러에서 담길 모델값
 */
@ControllerAdvice
public class GlobalModelAttribute {
    @ModelAttribute("requestURI")
    public String getRequestURI(HttpServletRequest request) {
        return request.getRequestURI();
    }
}
