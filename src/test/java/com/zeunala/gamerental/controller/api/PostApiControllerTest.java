package com.zeunala.gamerental.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
class PostApiControllerTest {
    @Autowired
    PostApiController postApiController;

    MockMvc mock;

    @BeforeEach
    void setup() {
        mock = MockMvcBuilders.standaloneSetup(postApiController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @ParameterizedTest
    @CsvSource({"1,true,0,2", "1,true,1,1", "1,false,2,1", "2,true,0,0"})
    @DisplayName("조건에 따른 판매글 정보 JSON 조회 테스트")
    void postlist(Integer productId, Boolean isRental, Integer status, Integer expectedPostsLength) throws Exception {
        mock.perform(get("/api/postlist")
                        .param("productId", Integer.toString(productId))
                        .param("isRental", Boolean.toString(isRental))
                        .param("status", Integer.toString(status)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts.length()", equalTo(expectedPostsLength)))
                .andDo(print());
    }
}