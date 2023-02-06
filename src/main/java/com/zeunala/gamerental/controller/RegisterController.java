package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.dto.RegisterSellForm;
import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.ProductService;
import com.zeunala.gamerental.service.UsersService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/register")
public class RegisterController {
    private final ProductService productService;
    private final UsersService usersService;

    @GetMapping("/buy")
    public String registerBuy() {
        return "register_buy";
    }

    @GetMapping("/sell/{productId}")
    public String registerSell(@PathVariable Integer productId, RegisterSellForm registerSellForm,
                               HttpSession session, Model model) {
        ProductInfo productInfo = productService.getProductInfoByProductId(productId);
        Users users = usersService.getUsersById((Integer) session.getAttribute(SessionName.LOGIN_USERS_ID));

        model.addAttribute("productInfo", productInfo);
        model.addAttribute("sellerInfo", users);
        return "register_sell";
    }
}
