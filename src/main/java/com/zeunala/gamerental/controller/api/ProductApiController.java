package com.zeunala.gamerental.controller.api;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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
    @GetMapping("/productlist")
    public Map<String, Object> productlist(@RequestParam(required = false) Integer categoryId,
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
    @GetMapping("/product/{productId}")
    public Map<String, Object> product(@PathVariable Integer productId) {
        ProductInfo productInfo = productService.getProductInfoByProductId(productId);

        if (productInfo == null) {
            return Map.of("product", Optional.empty());
        }

        return Map.of("product", productInfo);
    }
}
