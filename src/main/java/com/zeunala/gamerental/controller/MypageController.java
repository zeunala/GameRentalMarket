package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.PostService;
import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/mypage")
public class MypageController {
    private final PostService postService;
    private final DealService dealService;

    @GetMapping("/buy")
    public String mypageBuy() {
        return "mypage_buy";
    }

    @GetMapping("/sell")
    public String mypageSell(HttpSession session, Model model) {
        Integer sellerUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        List<PostInfo> registeringPosts = postService.getAllPostInfoBySellerUsersIdAndStatus(sellerUsersId, 0);
        List<DealInfo> activeDeal = dealService.getAllDealInfoBySellerUsersIdAndPostStatus(sellerUsersId, 1);
        List<DealInfo> closedDeal = dealService.getAllDealInfoBySellerUsersIdAndPostStatus(sellerUsersId, 2);

        model.addAttribute("registeringPosts", registeringPosts);
        model.addAttribute("activeDeal", activeDeal);
        model.addAttribute("closedDeal", closedDeal);

        return "mypage_sell";
    }
}
