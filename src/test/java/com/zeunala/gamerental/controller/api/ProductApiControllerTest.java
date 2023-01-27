package com.zeunala.gamerental.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
class ProductApiControllerTest {
    @Autowired
    ProductApiController productApiController;

    MockMvc mock;

    @BeforeEach
    void setup() {
        mock = MockMvcBuilders.standaloneSetup(productApiController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    @DisplayName("카테고리Id/start 없이 프로모션 정보들 JSON 조회 테스트")
    void productlist_NoCategoryIdAndNoStart_ReturnAll() throws Exception {
        mock.perform(get("/api/productlist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalCount").value(9)) // 모든 카테고리의 product 수 9개
                .andExpect(jsonPath("$.products.length()", equalTo(8))) // 항목은 8개까지만 노출
                .andDo(print());
    }

    @ParameterizedTest
    @CsvSource({"1,0,3,3", "1,2,3,1", "3,0,2,2", "-1,0,0,0"})
    @DisplayName("카테고리Id/start 있는 상태로 프로모션 정보들 JSON 조회 테스트")
    void productlist_WithCategoryIdAndStart_ReturnFiltered(Integer categoryId, Integer start,
                                                           Integer expectedTotalCount, Integer expectedProductsLength)
            throws Exception {
        mock.perform(get("/api/productlist")
                        .param("categoryId", Integer.toString(categoryId))
                        .param("start", Integer.toString(start)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalCount").value(expectedTotalCount))
                .andExpect(jsonPath("$.products.length()", equalTo(expectedProductsLength)))
                .andDo(print());
    }
}