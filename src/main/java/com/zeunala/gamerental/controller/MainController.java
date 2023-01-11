package com.zeunala.gamerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "redirect:main";
    }

    @GetMapping("/main")
    public String mainpage() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @GetMapping("/register/buy")
    public String registerBuy() {
        return "register_buy";
    }

    @GetMapping("/register/sell")
    public String registerSell() {
        return "register_sell";
    }

    @GetMapping("/mypage/buy")
    public String mypageBuy() {
        return "mypage_buy";
    }

    @GetMapping("/mypage/sell")
    public String mypageSell() {
        return "mypage_sell";
    }
}