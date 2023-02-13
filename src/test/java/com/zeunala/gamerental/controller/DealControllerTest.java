package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.util.SessionName;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@Slf4j
@SpringBootTest
class DealControllerTest {
    @Autowired
    DealController dealController;

    MockMvc mock;

    @BeforeEach
    void setup() {
        mock = MockMvcBuilders.standaloneSetup(dealController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @ParameterizedTest
    @CsvSource({"3,1", "4,1"})
    @DisplayName("판매자나 구매자가 대기상태인 거래글 삭제시 성공 테스트")
    void deleteDeal_ValidUsersAndStatus_Success(Integer sessionUsersId, Integer dealId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/deal/{dealId}".replace("{dealId}", dealId.toString()))
                        .session(session))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @ParameterizedTest
    @CsvSource({"3,10000", "4,-1"})
    @DisplayName("존재하지 않는 거래글 삭제시 실패 테스트")
    void deleteDeal_ValidUsersAndStatus_NotFound(Integer sessionUsersId, Integer dealId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/deal/{dealId}".replace("{dealId}", dealId.toString()))
                        .session(session))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,1"})
    @DisplayName("판매자나 구매자가 아닌데 거래글 삭제시 실패 테스트")
    void deleteDeal_InvalidUsers_Forbidden(Integer sessionUsersId, Integer dealId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/deal/{dealId}".replace("{dealId}", dealId.toString()))
                        .session(session))
                .andExpect(status().isForbidden())
                .andDo(print());
    }
}