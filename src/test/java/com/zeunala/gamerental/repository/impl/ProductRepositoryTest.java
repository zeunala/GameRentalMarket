package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("Product 테이블의 테스트 데이터들이 잘 조회되는지 확인")
    void countProductInfo() {
        assertThat(productRepository.countProductInfo()).isEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,3", "3,2", "4,1", "5,0", "6,0"})
    @DisplayName("Product 테이블의 각 카테고리별 데이터들이 잘 조회되는지 확인")
    void countProductInfoByCategoryId(Integer categoryId, Integer expected) {
        assertThat(productRepository.countProductInfoByCategoryId(categoryId)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Product 테이블의 정보들 조회 확인")
    void findMultipleProductInfo() {
        log.info("전체 상품 정보 조회: {}", productRepository.findMultipleProductInfo(0, 1000));
        assertThat(productRepository.findMultipleProductInfo(0, 4).size()).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource({"1,3", "2,3", "3,2", "4,1", "5,0", "6,0"})
    @DisplayName("Product 테이블의 각 카테고리별 정보들 조회 확인")
    void findMultipleProductInfoByCategoryId(Integer categoryId, Integer expected) {
        assertThat(productRepository.findMultipleProductInfoByCategoryId(categoryId, 0, 1000).size())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("1개의 상품 정보 확인")
    void findProductInfoByProductId() {
        ProductInfo productInfo = productRepository.findProductInfoByProductId(1);
        log.info("첫번째 상품 정보 조회: {}", productInfo);
        assertThat(productInfo).isNotNull();
    }

    @Test
    @DisplayName("존재하지 않는 상품 정보 확인시 null 리턴")
    void findProductInfoByProductId_NotExist_ReturnNull() {
        ProductInfo productInfo = productRepository.findProductInfoByProductId(10000);
        assertThat(productInfo).isNull();
    }
}