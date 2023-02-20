package com.zeunala.gamerental.controller.api;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Tag(name = "상품 API", description = "상품 관련 API")
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    /**
     * categoryId 에 해당하는 상품 정보를 start 번째부터 정해진 개수만큼 반환한다.
     *
     * @param categoryId 조회할 categoryId (없을 경우 모든 카테고리)
     * @param start      가져올 상품 정보의 시작 인덱스(없을 경우 기본값 0)
     * @return {"totalCount: (카테고리의 총 product 개수), "products": [상품 정보 배열] }
     */
    @Operation(summary = "여러 상품 조회", description = "categoryId에 해당하는 상품 정보를 start 번째부터 정해진 개수만큼 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
    @GetMapping("/productlist")
    public Map<String, Object> productlist(@Parameter(description = "조회할 categoryId (없을 경우 모든 카테고리)")
                                           @RequestParam(required = false) Integer categoryId,
                                           @Parameter(description = "가져올 상품 정보의 시작 인덱스 (없을 경우 기본값 0)")
                                           @RequestParam(defaultValue = "0") Integer start) {
        if (categoryId == null) {
            return Map.of("totalCount", productService.getCount(),
                    "products", productService.getMultipleProductInfo(start));
        }

        return Map.of("totalCount", productService.getCountByCategoryId(categoryId),
                "products", productService.getMultipleProductInfoByCategoryId(categoryId, start));
    }

    /**
     * productId 에 해당하는 상품 1개의 정보를 반환한다.
     *
     * @param productId 조회할 productId
     * @return {"product": (상품 정보) }
     */
    @Operation(summary = "1개 상품 조회", description = "productId에 해당하는 1개의 상품 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
    @GetMapping("/product/{productId}")
    public Map<String, Object> product(@Parameter(description = "조회할 productId")
                                       @PathVariable Integer productId) {
        ProductInfo productInfo = productService.getProductInfoByProductId(productId);

        if (productInfo == null) {
            return Map.of("product", Optional.empty());
        }

        return Map.of("product", productInfo);
    }
}
