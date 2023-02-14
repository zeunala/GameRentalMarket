package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.UsersService;
import com.zeunala.gamerental.util.DealStatus;
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
        if (!isBuyer(dealId, session) && !isSeller(dealId, session)) {
            return new ResponseEntity<>(Map.of("message", "판매자 또는 구매자만 삭제 가능합니다."), HttpStatus.FORBIDDEN);
        }

        // 거래 대기 상태가 아니면 삭제 불가
        if (dealService.getDealInfoByDealId(dealId).getDealStatus() != DealStatus.BEFORE_DEAL) {
            return new ResponseEntity<>(Map.of("message", "거래 대기 물품만 삭제 가능합니다."), HttpStatus.FORBIDDEN);
        }

        // 글 삭제
        if (!dealService.deleteDealById(dealId)) {
            return new ResponseEntity<>(Map.of("message", "삭제할 글이 없습니다."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Map.of("message", "삭제가 완료되었습니다."), HttpStatus.OK);
    }

    private Boolean isBuyer(Integer dealId, HttpSession session) {
        Integer sessionUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        String buyerUsersNickname = dealService.getDealInfoByDealId(dealId).getBuyerUsersNickname();
        Integer buyerUsersId = usersService.getUsersByNickname(buyerUsersNickname).getId();

        return sessionUsersId.equals(buyerUsersId);
    }

    private Boolean isSeller(Integer dealId, HttpSession session) {
        Integer sessionUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        String sellerUsersNickname = dealService.getDealInfoByDealId(dealId).getSellerUsersNickname();
        Integer sellerUsersId = usersService.getUsersByNickname(sellerUsersNickname).getId();

        return sessionUsersId.equals(sellerUsersId);
    }


    @PatchMapping("/{dealId}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> updateDealStatus(@PathVariable Integer dealId,
                                                                @RequestParam String action, HttpSession session) {
        // 존재하지 않는 거래글인 경우 접근 불가
        if (dealService.getDealInfoByDealId(dealId) == null) {
            return new ResponseEntity<>(Map.of("message", "존재하지 않는 거래입니다."), HttpStatus.NOT_FOUND);
        }
        
        switch (action) {
            case "wire-money": // 입금완료
                return wireMoney(dealId, session);
            case "receipt-product": // 상품수령
                return receiptProduct(dealId, session);
            case "return-product": // 물건반환확인
                return returnProduct(dealId, session);
            case "return-deposit": // 보증금반환확인
                return returnDeposit(dealId, session);
            default:
                return invalidRequestResponse();
        }
    }

    /**
     * 입금완료
     *
     * 구매자만 가능
     * 렌탈/택배에서 dealStatus를 0에서 1로 변경
     * 중고/택배에서 dealStatus를 0에서 1로 변경
     */
    private ResponseEntity<Map<String, String>> wireMoney(Integer dealId, HttpSession session) {
        // 구매자가 아닌 경우 접근 불가
        if (!isBuyer(dealId, session)) {
            return notBuyerResponse();
        }

        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        // 렌탈/택배, 중고/택배
        if (dealInfo.getDirectFlag() == 0) {
            if (!dealService.changeStatusById(dealId, DealStatus.BEFORE_DEAL, DealStatus.AFTER_WIRE_MONEY)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        return invalidRequestResponse();
    }

    /**
     * 상품수령
     *
     * 구매자만 가능
     * 렌탈/택배에서 dealStatus를 1에서 2로 변경
     * 중고/택배에서 dealStatus를 1에서 4로 변경
     * 렌탈/직거래에서 dealStatus를 0에서 2로 변경
     * 중고/직거래에서 dealStatus를 0에서 4로 변경
     */
    private ResponseEntity<Map<String, String>> receiptProduct(Integer dealId, HttpSession session) {
        // 구매자가 아닌 경우 접근 불가
        if (!isBuyer(dealId, session)) {
            return notBuyerResponse();
        }

        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        // 렌탈/택배
        if (dealInfo.getRentalFlag() == 1 && dealInfo.getDirectFlag() == 0) {
            if (!dealService.changeStatusById(dealId, DealStatus.AFTER_WIRE_MONEY, DealStatus.IN_RENTAL)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        // 중고/택배
        if (dealInfo.getRentalFlag() == 0 && dealInfo.getDirectFlag() == 0) {
            if (!dealService.changeStatusById(dealId, DealStatus.AFTER_WIRE_MONEY, DealStatus.AFTER_DEAL)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        // 렌탈/직거래
        if (dealInfo.getRentalFlag() == 1 && dealInfo.getDirectFlag() == 1) {
            if (!dealService.changeStatusById(dealId, DealStatus.BEFORE_DEAL, DealStatus.IN_RENTAL)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        // 중고/직거래
        if (dealInfo.getRentalFlag() == 0 && dealInfo.getDirectFlag() == 1) {
            if (!dealService.changeStatusById(dealId, DealStatus.BEFORE_DEAL, DealStatus.AFTER_DEAL)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        return invalidRequestResponse();
    }

    /**
     * 물건반환확인
     *
     * 판매자만 가능
     * 렌탈/택배에서 dealStatus를 2에서 3로 변경, 보증금이 없다면 4로 변경
     * 렌탈/직거래에서 dealStatus를 2에서 4로 변경
     */
    private ResponseEntity<Map<String, String>> returnProduct(Integer dealId, HttpSession session) {
        // 판매자가 아닌 경우 접근 불가
        if (!isSeller(dealId, session)) {
            return notSellerResponse();
        }

        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        // 렌탈/택배
        if (dealInfo.getRentalFlag() == 1 && dealInfo.getDirectFlag() == 0) {
            Integer afterStatus = DealStatus.DEPOSIT_REMAIN;
            if (dealInfo.getDeposit() == null) {
                afterStatus = DealStatus.AFTER_DEAL;
            }

            if (!dealService.changeStatusById(dealId, DealStatus.IN_RENTAL, afterStatus)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        // 렌탈/직거래
        if (dealInfo.getRentalFlag() == 1 && dealInfo.getDirectFlag() == 1) {
            if (!dealService.changeStatusById(dealId, DealStatus.IN_RENTAL, DealStatus.AFTER_DEAL)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        return invalidRequestResponse();
    }

    /**
     * 보증금반환 확인
     * 구매자만 가능
     * 렌탈/택배에서 dealStatus를 3에서 4로 변경
     */
    private ResponseEntity<Map<String, String>> returnDeposit(Integer dealId, HttpSession session) {
        // 구매자가 아닌 경우 접근 불가
        if (!isBuyer(dealId, session)) {
            return notBuyerResponse();
        }

        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        // 렌탈/택배
        if (dealInfo.getRentalFlag() == 1 && dealInfo.getDirectFlag() == 0) {
            if (!dealService.changeStatusById(dealId, DealStatus.DEPOSIT_REMAIN, DealStatus.AFTER_DEAL)) {
                return invalidRequestResponse();
            }
            return requestCompleteResponse();
        }
        return invalidRequestResponse();
    }

    private static ResponseEntity<Map<String, String>> invalidRequestResponse() {
        return new ResponseEntity<>(Map.of("message", "유효하지 않은 요청입니다."), HttpStatus.FORBIDDEN);
    }
    
    private static ResponseEntity<Map<String, String>> requestCompleteResponse() {
        return new ResponseEntity<>(Map.of("message", "처리가 완료되었습니다."), HttpStatus.OK);
    }

    private static ResponseEntity<Map<String, String>> notBuyerResponse() {
        return new ResponseEntity<>(Map.of("message", "구매자만 입금완료가 가능합니다."), HttpStatus.FORBIDDEN);
    }
    private static ResponseEntity<Map<String, String>> notSellerResponse() {
        return new ResponseEntity<>(Map.of("message", "판매자만 입금완료가 가능합니다."), HttpStatus.FORBIDDEN);
    }
}
