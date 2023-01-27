package com.zeunala.gamerental.controller.api;

import com.zeunala.gamerental.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class PromotionApiController {
    private final PromotionService promotionService;

    /**
     * 행사중인 프로모션 목록을 모두 반환한다.
     *
     * @return {"promotions": [{"id": 0, "filePath":... "url":...}, ...]}
     */
    @GetMapping("/promotionlist")
    public Map<String, Object> promotionlist() {
        return Map.of("promotions", promotionService.getAllPromotionInfo());
    }
}
