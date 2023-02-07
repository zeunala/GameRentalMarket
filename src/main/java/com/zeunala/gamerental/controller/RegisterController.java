package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.Post;
import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.dto.RegisterSellForm;
import com.zeunala.gamerental.dto.Users;
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

    @GetMapping("/buy")
    public String registerBuy() {
        return "register_buy";
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
            Post post = new Post(productId, (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID),
                    registerSellForm.getRentalFlag(), registerSellForm.getDirectFlag(), registerSellForm.getPrice(),
                    registerSellForm.getExtensionPrice(), registerSellForm.getDeposit(), registerSellForm.getComment());
            Post registeredPost = postService.registerPost(post);
            log.info("추가된 판매글 정보: {}", registeredPost);
            return "mypage_sell";
        } catch (Exception e) {
            bindingResult.reject("postFail", "정상적이지 않은 판매글 등록입니다.");
            addInfoToModel(productId, session, model);
            return "register_sell";
        }
    }

    private void addInfoToModel(Integer productId, HttpSession session, Model model) {
        ProductInfo productInfo = productService.getProductInfoByProductId(productId);
        Users users = usersService.getUsersById((Integer) session.getAttribute(SessionName.LOGIN_USERS_ID));

        model.addAttribute("productInfo", productInfo);
        model.addAttribute("sellerInfo", users);
    }
}
