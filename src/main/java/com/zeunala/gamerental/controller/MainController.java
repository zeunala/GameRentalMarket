package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.service.PostService;
import com.zeunala.gamerental.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        List<PostInfo> rentalPosts = postService.getAllPostInfoByProductIdAndRentalFlagAndStatus(productId, 1, 0);
        List<PostInfo> usedPosts = postService.getAllPostInfoByProductIdAndRentalFlagAndStatus(productId, 0, 0);

        model.addAttribute("title", productInfo.getTitle());
        model.addAttribute("imgUrl", "/" + productInfo.getFilePath());
        model.addAttribute("minRentalPrice", productInfo.getMinRentalPrice());
        model.addAttribute("minUsedPrice", productInfo.getMinUsedPrice());
        model.addAttribute("productId", productId);

        model.addAttribute("rentalPosts", rentalPosts);
        model.addAttribute("usedPosts", usedPosts);

        return "detail";
    }
}