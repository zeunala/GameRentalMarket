package com.zeunala.gamerental.repository.impl;

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
class JdbcTemplateProductRepositoryTest {
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
}