package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.UsersService;
import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @DeleteMapping("/{dealId}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> deleteDeal(@PathVariable Integer dealId, HttpSession session) {
        // 존재하지 않는 거래글인 경우 접근 불가
        if (dealService.getDealInfoByDealId(dealId) == null) {
            return new ResponseEntity<>(Map.of("message", "삭제할 글이 없습니다."), HttpStatus.NOT_FOUND);
        }

        // 판매자나 구매자가 아닌 경우 접근 불가
        if (!isBuyerOrSeller(dealId, session)) {
            return new ResponseEntity<>(Map.of("message", "판매자 또는 구매자만 삭제 가능합니다."), HttpStatus.FORBIDDEN);
        }

        // 거래 대기 상태가 아니면 삭제 불가
        if (dealService.getDealInfoByDealId(dealId).getDealStatus() != 0) {
            return new ResponseEntity<>(Map.of("message", "거래 대기 물품만 삭제 가능합니다."), HttpStatus.FORBIDDEN);
        }

        // 글 삭제
        if (!dealService.deleteDealById(dealId)) {
            return new ResponseEntity<>(Map.of("message", "삭제할 글이 없습니다."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Map.of("message", "삭제가 완료되었습니다."), HttpStatus.OK);
    }

    private Boolean isBuyerOrSeller(Integer dealId, HttpSession session) {
        Integer sessionUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        String sellerUsersNickname = dealService.getDealInfoByDealId(dealId).getSellerUsersNickname();
        Integer sellerUsersId = usersService.getUsersByNickname(sellerUsersNickname).getId();
        String buyerUsersNickname = dealService.getDealInfoByDealId(dealId).getBuyerUsersNickname();
        Integer buyerUsersId = usersService.getUsersByNickname(buyerUsersNickname).getId();

        return sessionUsersId.equals(sellerUsersId) || sessionUsersId.equals(buyerUsersId);
    }
}
