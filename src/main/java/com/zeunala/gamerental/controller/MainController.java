package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.service.PostService;
import com.zeunala.gamerental.service.ProductService;
import com.zeunala.gamerental.util.PostStatus;
import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;
    private final PostService postService;

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
        List<PostInfo> rentalPosts = postService.getAllPostInfoByProductIdAndRentalFlagAndStatus(
                productId, 1, PostStatus.REGISTERING_POST
        );
        List<PostInfo> usedPosts = postService.getAllPostInfoByProductIdAndRentalFlagAndStatus(
                productId, 0, PostStatus.REGISTERING_POST
        );

        model.addAttribute("title", productInfo.getTitle());
        model.addAttribute("imgUrl", "/" + productInfo.getFilePath());
        model.addAttribute("minRentalPrice", productInfo.getMinRentalPrice());
        model.addAttribute("minUsedPrice", productInfo.getMinUsedPrice());
        model.addAttribute("productId", productId);

        model.addAttribute("rentalPosts", rentalPosts);
        model.addAttribute("usedPosts", usedPosts);

        return "detail";
    }

    @GetMapping("/logout")
    public String logout(@RequestParam(defaultValue = "/") String redirect, HttpSession session) {
        session.removeAttribute(SessionName.LOGIN_USERS_ID);
        return "redirect:" + redirect;
    }
}