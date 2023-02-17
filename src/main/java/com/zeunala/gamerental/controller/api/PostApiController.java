package com.zeunala.gamerental.controller.api;

import com.zeunala.gamerental.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "판매글 API", description = "판매글 관련 API")
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class PostApiController {
    private final PostService postService;

    /**
     * 상품 id와 렌탈여부, status 값이 일치하는 모든 판매글 정보를 반환한다.
     *
     * @param productId 상품 id 조건
     * @param isRental  렌탈 여부조건 (렌탈일 경우 true, 중고판매일 경우 false)
     * @param status    상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return {"posts": [해당 조건을 모두 만족하는 판매글 정보들의 배열] }
     */
    @Operation(summary = "판매글 조회", description = "상품 id, 렌탈여부, status값이 일치하는 모든 판매글 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
    @GetMapping("/postlist")
    public Map<String, Object> postlist(@Parameter(description = "상품 id 조건") Integer productId,
                                        @Parameter(description = "렌탈 여부 조건 (렌탈일 경우 true, 중고판매일 경우 false)") Boolean isRental,
                                        @Parameter(description = "상태 조건 (대기물품 0, 거래중 1, 거래종료 2)") Integer status) {
        Integer rentalFlag = isRental ? 1 : 0;

        return Map.of("posts",
                postService.getAllPostInfoByProductIdAndRentalFlagAndStatus(productId, rentalFlag, status));
    }
}
