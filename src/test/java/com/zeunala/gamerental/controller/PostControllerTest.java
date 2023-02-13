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
class PostControllerTest {
    @Autowired
    PostController postController;

    MockMvc mock;

    @BeforeEach
    void setup() {
        mock = MockMvcBuilders.standaloneSetup(postController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2"})
    @DisplayName("판매자가 거래전인 본인의 판매글 삭제시 성공 테스트")
    void deletePost_ValidUsersAndStatus_Success(Integer sessionUsersId, Integer postId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/post/{postId}".replace("{postId}", postId.toString()))
                        .session(session))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @ParameterizedTest
    @CsvSource({"1,10000", "2,-1"})
    @DisplayName("존재하지 않는 판매글 삭제시 실패 테스트")
    void deletePost_InvalidPostId_NotFound(Integer sessionUsersId, Integer postId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/post/{postId}".replace("{postId}", postId.toString()))
                        .session(session))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @ParameterizedTest
    @CsvSource({"2,1", "1,2"})
    @DisplayName("판매자가 아닌데 판매글 삭제시 실패 테스트")
    void deletePost_InvalidUsers_Forbidden(Integer sessionUsersId, Integer postId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/post/{postId}".replace("{postId}", postId.toString()))
                        .session(session))
                .andExpect(status().isForbidden())
                .andDo(print());
    }

    @ParameterizedTest
    @CsvSource({"3,3", "1,4"})
    @DisplayName("거래전이 아닌 판매글 삭제시 실패 테스트")
    void deletePost_InvalidStatus_Forbidden(Integer sessionUsersId, Integer postId) throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(SessionName.LOGIN_USERS_ID, sessionUsersId);

        mock.perform(delete("/post/{postId}".replace("{postId}", postId.toString()))
                        .session(session))
                .andExpect(status().isForbidden())
                .andDo(print());
    }
}