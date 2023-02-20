package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
@Slf4j
@SpringBootTest
class UsersServiceImplTest {
    @Autowired
    UsersService usersService;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("id로 유저정보 조회")
    void getUsersById(Integer id) {
        Users users = usersService.getUsersById(id);
        log.info("{}번 유저 정보: {}", id, users);
        assertThat(users.getId()).isEqualTo(id);
    }

    @ParameterizedTest
    @ValueSource(ints = {11111111, 22222222, 33333333, -1})
    @DisplayName("존재하지 않는 id로 유저정보 조회시 null 리턴")
    void getUsersById_NotExist_ReturnNull(Integer id) {
        Users users = usersService.getUsersById(id);
        assertThat(users).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "BBB456", "CCC789", "DDD369"})
    @DisplayName("loginId로 유저정보 조회")
    void getUsersByLoginId(String loginId) {
        Users users = usersService.getUsersByLoginId(loginId);
        assertThat(users.getLoginId()).isEqualTo(loginId);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa123", "bbb456", "CCC", " ", ""})
    @DisplayName("존재하지 않는 loginId로 유저정보 조회시 null 리턴")
    void getUsersByLoginId_NotExist_ReturnNull(String loginId) {
        Users users = usersService.getUsersByLoginId(loginId);
        assertThat(users).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA@gmail.com", "BBB@gmail.com", "CCC@gmail.com", "DDD@gmail.com"})
    @DisplayName("email로 유저정보 조회")
    void getUsersByEmail(String email) {
        Users users = usersService.getUsersByEmail(email);
        assertThat(users.getEmail()).isEqualTo(email);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "AAA", "AAA@naver.com", " ", ""})
    @DisplayName("존재하지 않는 email로 유저정보 조회시 null 리턴")
    void getUsersByEmail_NotExist_ReturnNull(String email) {
        Users users = usersService.getUsersByEmail(email);
        assertThat(users).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "BBB", "CCC", "DDD"})
    @DisplayName("nickname으로 유저정보 조회")
    void getUsersByNickname(String nickname) {
        Users users = usersService.getUsersByNickname(nickname);
        assertThat(users.getNickname()).isEqualTo(nickname);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "AAA@gmail.com", "aaa", " ", ""})
    @DisplayName("존재하지 않는 nickname으로 유저정보 조회시 null 리턴")
    void getUsersByNickname_NotExist_ReturnNull(String nickname) {
        Users users = usersService.getUsersByNickname(nickname);
        assertThat(users).isNull();
    }

    @Test
    @DisplayName("새로운 유저 추가")
    void registerUsers() {
        Users users = new Users("무", "EEE", "EEE@gmail.com", "010-5555-5555",
                "대전", "EEE258", "2580");
        Users savedUsers = usersService.registerUsers(users);
        log.info("추가된 유저 정보: {}", savedUsers);
        assertThat(savedUsers.getId()).isNotNull();
    }

    @Test
    @DisplayName("중복된 닉네임 입력시 예외 발생")
    void registerUsers_DuplicateNickname_ThrowIllegalArgumentException() {
        Users users1 = new Users("무", "EEE", "EEE@gmail.com", "010-5555-5555",
                "대전", "EEE258", "2580");
        Users users2 = new Users("기", "EEE", "FFF@gmail.com", "010-6666-6666",
                "대구", "FFF147", "1470");
        assertDoesNotThrow(() -> usersService.registerUsers(users1));
        assertThrows(IllegalArgumentException.class, () -> usersService.registerUsers(users2));
    }

    @ParameterizedTest
    @CsvSource({"AAA123,1234", "BBB456,4567", "CCC789,7890", "DDD369,3690"})
    @DisplayName("올바른 비밀번호 입력시 true 리턴")
    void login_ValidPassword_ReturnTrue(String loginId, String loginPassword) {
        assertThat(usersService.login(loginId, loginPassword)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"AAA123,''", "BBB456,'4567 '", "CCC789,' or  '1' = '1", "DDD369,1111');DROP TABLE users;--"})
    @DisplayName("잘못된 비밀번호 입력시 false 리턴")
    void login_InvalidPassword_ReturnFalse(String loginId, String loginPassword) {
        assertThat(usersService.login(loginId, loginPassword)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource({"'AAA123 ',1234", "bbb456,4567", "CCc789,7890", "DDD,3690",
            "AAA1234,''", "BBB4567,'4567 '", "CCC789 ,' or  '1' = '1", "'',1111');DROP TABLE users;--"})
    @DisplayName("존재하지 않는 아이디 입력시 false 리턴")
    void login_NotExistId_ReturnFalse(String loginId, String loginPassword) {
        assertThat(usersService.login(loginId, loginPassword)).isEqualTo(false);
    }
}