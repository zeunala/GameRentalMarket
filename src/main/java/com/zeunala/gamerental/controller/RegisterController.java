package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.*;
import com.zeunala.gamerental.service.DealService;
import com.zeunala.gamerental.service.PostService;
import com.zeunala.gamerental.service.ProductService;
import com.zeunala.gamerental.service.UsersService;
import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/register")
@Slf4j
public class RegisterController {
    private final ProductService productService;
    private final UsersService usersService;
    private final PostService postService;
    private final DealService dealService;

    @GetMapping("/buy/{postId}")
    public String registerBuy(@PathVariable Integer postId, HttpSession session, Model model) {
        PostInfo postInfo = postService.getPostInfoByPostId(postId);
        UsersDto usersDto = usersService.getUsersById((Integer) session.getAttribute(SessionName.LOGIN_USERS_ID));

        model.addAttribute("postInfo", postInfo);
        model.addAttribute("buyerInfo", usersDto);

        return "register_buy";
    }

    @PostMapping("/buy/{postId}")
    public String registerBuy(@PathVariable Integer postId, HttpSession session, Model model, Integer totalPrice) {
        try {
            DealDto dealDto = new DealDto(postId, (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID), totalPrice);
            DealDto registeredDealDto = dealService.registerDeal(dealDto);
            log.info("추가된 거래글 정보: {}", registeredDealDto);
            return "redirect:/mypage/buy";
        } catch (IllegalStateException e) {
            log.info("{}", e.getMessage());
            log.info("유효하지 않은 거래글");
            return "redirect:/main";
        }
    }

    @GetMapping("/sell/{productId}")
    public String registerSell(RegisterSellForm registerSellForm,
                               @PathVariable Integer productId, HttpSession session, Model model) {
        addInfoToModel(productId, session, model);
        return "register_sell";
    }

    @PostMapping("/sell/{productId}")
    public String registerSell(@Valid RegisterSellForm registerSellForm, BindingResult bindingResult,
                               @PathVariable Integer productId, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            addInfoToModel(productId, session, model);
            return "register_sell";
        }

        try {
            PostDto postDto = new PostDto(productId, (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID),
                    registerSellForm.getRentalFlag(), registerSellForm.getDirectFlag(), registerSellForm.getPrice(),
                    registerSellForm.getExtensionPrice(), registerSellForm.getDeposit(), registerSellForm.getComment());
            PostDto registeredPostDto = postService.registerPost(postDto);
            log.info("추가된 판매글 정보: {}", registeredPostDto);
            return "redirect:/mypage/sell";
        } catch (Exception e) {
            log.info("{}", e.getMessage());
            bindingResult.reject("postFail", "정상적이지 않은 판매글 등록입니다.");
            addInfoToModel(productId, session, model);
            return "register_sell";
        }
    }

    private void addInfoToModel(Integer productId, HttpSession session, Model model) {
        ProductInfo productInfo = productService.getProductInfoByProductId(productId);
        UsersDto usersDto = usersService.getUsersById((Integer) session.getAttribute(SessionName.LOGIN_USERS_ID));

        model.addAttribute("productInfo", productInfo);
        model.addAttribute("sellerInfo", usersDto);
    }
}
