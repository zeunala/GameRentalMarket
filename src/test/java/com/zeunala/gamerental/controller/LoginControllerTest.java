package com.zeunala.gamerental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
class LoginControllerTest {
    @Autowired
    LoginController loginController;

    @Autowired
    ObjectMapper objectMapper;

    MockMvc mock;

    @BeforeEach
    void setup() {
        mock = MockMvcBuilders.standaloneSetup(loginController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @ParameterizedTest
    @CsvSource({"AAA123,1234", "BBB456,4567", "CCC789,7890", "DDD369,3690"})
    @DisplayName("로그인 성공시 리다이렉트 테스트")
    void login_ValidIdAndPassword_Success(String loginId, String loginPassword) throws Exception {
        Map<String, String> param = Map.of("loginId", loginId, "loginPassword", loginPassword);

        mock.perform(post("/login")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .param("loginId", loginId)
                        .param("loginPassword", loginPassword))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }
}