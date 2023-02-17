package com.zeunala.gamerental.controller.api;

import com.zeunala.gamerental.service.PromotionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "프로모션 API", description = "프로모션 관련 API")
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
    @Operation(summary = "프로모션 조회", description = "행사중인 프로모션 목록을 모두 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
    @GetMapping("/promotionlist")
    public Map<String, Object> promotionlist() {
        return Map.of("promotions", promotionService.getAllPromotionInfo());
    }
}
