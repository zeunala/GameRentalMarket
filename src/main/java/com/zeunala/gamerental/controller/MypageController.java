package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.PostService;
import com.zeunala.gamerental.util.PostStatus;
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
    public String mypageBuy(HttpSession session, Model model) {
        Integer buyerUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        List<DealInfo> activeDeal = dealService.getAllDealInfoByBuyerUsersIdAndPostStatus(
                buyerUsersId, PostStatus.ACTIVE_DEAL
        );
        List<DealInfo> closedDeal = dealService.getAllDealInfoByBuyerUsersIdAndPostStatus(
                buyerUsersId, PostStatus.CLOSED_DEAL
        );

        model.addAttribute("activeDeal", activeDeal);
        model.addAttribute("closedDeal", closedDeal);

        return "mypage_buy";
    }

    @GetMapping("/sell")
    public String mypageSell(HttpSession session, Model model) {
        Integer sellerUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        List<PostInfo> registeringPosts = postService.getAllPostInfoBySellerUsersIdAndStatus(
                sellerUsersId, PostStatus.REGISTERING_POST
        );
        List<DealInfo> activeDeal = dealService.getAllDealInfoBySellerUsersIdAndPostStatus(
                sellerUsersId, PostStatus.ACTIVE_DEAL
        );
        List<DealInfo> closedDeal = dealService.getAllDealInfoBySellerUsersIdAndPostStatus(
                sellerUsersId, PostStatus.CLOSED_DEAL
        );

        model.addAttribute("registeringPosts", registeringPosts);
        model.addAttribute("activeDeal", activeDeal);
        model.addAttribute("closedDeal", closedDeal);

        return "mypage_sell";
    }
}
