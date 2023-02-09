package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.LoginForm;
import com.zeunala.gamerental.service.UsersService;
import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/login")
public class LoginController {
    private final UsersService usersService;

    @GetMapping
    public String login(LoginForm loginForm) {
        return "login";
    }

    @PostMapping
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        if (!usersService.login(loginForm.getLoginId(), loginForm.getLoginPassword())) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호를 잘못 입력했습니다.");
            return "login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID,
                usersService.getUsersByLoginId(loginForm.getLoginId()).getId());
        return "redirect:/main";
    }
}
