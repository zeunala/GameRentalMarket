package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;

    @GetMapping("/")
    public String index() {
        return "redirect:main";
    }

    @GetMapping("/main")
    public String mainpage() {
        return "main";
    }

    @GetMapping("/detail/{productId}")
    public String detail(@PathVariable Integer productId, Model model) {
        ProductInfo productInfo = productService.getProductInfoByProductId(productId);

        model.addAttribute("title", productInfo.getTitle());
        model.addAttribute("imgUrl", "/" + productInfo.getFilePath());
        model.addAttribute("minRentalPrice", productInfo.getMinRentalPrice());
        model.addAttribute("minUsedPrice", productInfo.getMinUsedPrice());

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