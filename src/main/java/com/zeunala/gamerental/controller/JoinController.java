package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.JoinForm;
import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/join")
@Slf4j
public class JoinController {
    private final UsersService usersService;

    @GetMapping
    public String join(JoinForm joinForm) {
        return "join";
    }

    @PostMapping
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult, HttpServletRequest request) {
        checkDuplicatedField(joinForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "join";
        }

        try {
            Users users = new Users(joinForm.getName(), joinForm.getNickname(), joinForm.getEmail(), joinForm.getTel(),
                    joinForm.getHomeAddressSido() + " " + joinForm.getHomeAddressSigugun(),
                    joinForm.getLoginId(), joinForm.getLoginPassword());
            Users registeredUsers = usersService.registerUsers(users);
            log.info("가입된 유저 정보: {}", registeredUsers);

            HttpSession session = request.getSession();
            session.setAttribute(SessionName.LOGIN_USERS_ID,
                    usersService.getUsersByLoginId(joinForm.getLoginId()).getId());
            return "redirect:main";
        } catch (IllegalArgumentException e) {
            bindingResult.reject("joinFail", "중복된 정보로 가입을 시도했습니다.");
            return "join";
        }
    }

    private void checkDuplicatedField(JoinForm joinForm, BindingResult bindingResult) {
        if (usersService.getUsersByLoginId(joinForm.getLoginId()) != null) {
            bindingResult.rejectValue("loginId", "duplicated", "이미 존재하는 아이디입니다.");
        }
        if (usersService.getUsersByNickname(joinForm.getNickname()) != null) {
            bindingResult.rejectValue("nickname", "duplicated", "이미 존재하는 닉네임입니다.");
        }
        if (usersService.getUsersByEmail(joinForm.getEmail()) != null) {
            bindingResult.rejectValue("email", "duplicated", "이미 가입된 이메일입니다.");
        }
    }
}
