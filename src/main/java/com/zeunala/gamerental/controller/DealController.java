package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.UsersService;
import com.zeunala.gamerental.util.SessionName;
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
    public String dealBuy(@PathVariable Integer dealId, HttpSession session, Model model) {
        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        Users seller = usersService.getUsersByNickname(dealInfo.getSellerUsersNickname());

        // 구매자가 아닌 경우 접근 불가
        Integer buyerId = usersService.getUsersByNickname(dealInfo.getBuyerUsersNickname()).getId();
        if (!buyerId.equals((Integer) session.getAttribute(SessionName.LOGIN_USERS_ID))) {
            return "redirect:/main";
        }

        model.addAttribute("deal", dealInfo);
        model.addAttribute("seller", seller);
        return "deal_buy";
    }

    @GetMapping("/sell/{dealId}")
    public String dealSell(@PathVariable Integer dealId, HttpSession session, Model model) {
        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        Users buyer = usersService.getUsersByNickname(dealInfo.getBuyerUsersNickname());

        // 판매자가 아닌 경우 접근 불가
        Integer sellerId = usersService.getUsersByNickname(dealInfo.getSellerUsersNickname()).getId();
        if (!sellerId.equals((Integer) session.getAttribute(SessionName.LOGIN_USERS_ID))) {
            return "redirect:/main";
        }

        model.addAttribute("deal", dealInfo);
        model.addAttribute("buyer", buyer);
        return "deal_sell";
    }
}
