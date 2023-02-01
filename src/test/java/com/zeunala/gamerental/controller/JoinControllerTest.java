package com.zeunala.gamerental.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
class JoinControllerTest {
    @Autowired
    JoinController joinController;

    MockMvc mock;

    @BeforeEach
    void setup() {
        mock = MockMvcBuilders.standaloneSetup(joinController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @ParameterizedTest
    @CsvSource({"XXX123,1234,김철수,철수,서울특별시,강남구,XXX@naver.com,010-7777-8888",
            "YYY321,4321,김영희,영희,인천광역시,계양구,YYY@daum.net,010-9999-0000",})
    @DisplayName("회원가입 성공시 리다이렉트 테스트")
    void join_ValidField_Success(String loginId, String loginPassword, String name, String nickname,
                                 String homeAddressSido, String homeAddressSigugun,
                                 String email, String tel) throws Exception {
        mock.perform(post("/join")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("loginId", loginId)
                        .param("loginPassword", loginPassword)
                        .param("name", name)
                        .param("nickname", nickname)
                        .param("homeAddressSido", homeAddressSido)
                        .param("homeAddressSigugun", homeAddressSigugun)
                        .param("email", email)
                        .param("tel", tel))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }
}