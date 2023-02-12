package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/deal")
@Slf4j
public class DealController {
    private final DealService dealService;
    private final UsersService usersService;

    @GetMapping("/buy/{dealId}")
    public String dealBuy(@PathVariable Integer dealId, Model model) {
        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        Users seller = usersService.getUsersByNickname(dealInfo.getSellerUsersNickname());

        model.addAttribute("deal", dealInfo);
        model.addAttribute("seller", seller);
        return "deal_buy";
    }

    @GetMapping("/sell/{dealId}")
    public String dealSell(@PathVariable Integer dealId, Model model) {
        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        Users buyer = usersService.getUsersByNickname(dealInfo.getBuyerUsersNickname());

        model.addAttribute("deal", dealInfo);
        model.addAttribute("buyer", buyer);
        return "deal_sell";
    }
}
