package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    ProductService productService;


    @Test
    @DisplayName("테스트 데이터들의 개수가 잘 조회되는지 확인")
    void getCount() {
        assertThat(productService.getCount()).isEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,3", "3,2", "4,1", "5,0", "6,0"})
    @DisplayName("테스트 데이터들의 개수가 각 카테고리별로 잘 조회되는지 확인")
    void getCountByCategoryId(Integer categoryId, Integer expected) {
        assertThat(productService.getCountByCategoryId(categoryId)).isEqualTo(expected);
    }

    @Test
    @DisplayName("테스트 데이터들의 조회 확인")
    void getMultipleProductInfo() {
        List<ProductInfo> allProductInfo = productService.getMultipleProductInfo(0);
        log.info("전체 상품 정보 조회: {}", allProductInfo);
        assertThat(allProductInfo.size()).isLessThanOrEqualTo(ProductService.COUNT_PER_GET_ONCE);
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,3", "3,2", "4,1", "5,0", "6,0"})
    @DisplayName("테스트 데이터들의 각 카테고리별 정보들 조회 확인")
    void getMultipleProductInfoByCategoryId(Integer categoryId, Integer expected) {
        assertThat(productService.getMultipleProductInfoByCategoryId(categoryId, 0).size())
                .isGreaterThanOrEqualTo(expected)
                .isLessThanOrEqualTo(ProductService.COUNT_PER_GET_ONCE);
    }

    @Test
    @DisplayName("1개의 상품 정보 확인")
    void getProductInfoByProductId() {
        ProductInfo productInfo = productService.getProductInfoByProductId(1);
        log.info("첫번째 상품 정보 조회: {}", productInfo);
        assertThat(productInfo).isNotNull();
    }

    @Test
    @DisplayName("존재하지 않는 상품 정보 확인시 null 리턴")
    void getProductInfoByProductId_NotExist_ReturnNull() {
        ProductInfo productInfo = productService.getProductInfoByProductId(10000);
        assertThat(productInfo).isNull();
    }
}