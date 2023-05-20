package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.UsersDto;
import com.zeunala.gamerental.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
class JdbcTemplateUsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("id로 유저정보 조회")
    void findById(Integer id) {
        UsersDto usersDto = usersRepository.findById(id);
        log.info("{}번 유저 정보: {}", id, usersDto);
        assertThat(usersDto.getId()).isEqualTo(id);
    }

    @ParameterizedTest
    @ValueSource(ints = {11111111, 22222222, 33333333, -1})
    @DisplayName("존재하지 않는 id로 유저정보 조회시 null 리턴")
    void findById_NotExist_ReturnNull(Integer id) {
        UsersDto usersDto = usersRepository.findById(id);
        assertThat(usersDto).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "BBB456", "CCC789", "DDD369"})
    @DisplayName("loginId로 유저정보 조회")
    void findByLoginId(String loginId) {
        UsersDto usersDto = usersRepository.findByLoginId(loginId);
        assertThat(usersDto.getLoginId()).isEqualTo(loginId);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa123", "bbb456", "CCC", " ", ""})
    @DisplayName("존재하지 않는 loginId로 유저정보 조회시 null 리턴")
    void findByLoginId_NotExist_ReturnNull(String loginId) {
        UsersDto usersDto = usersRepository.findByLoginId(loginId);
        assertThat(usersDto).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA@gmail.com", "BBB@gmail.com", "CCC@gmail.com", "DDD@gmail.com"})
    @DisplayName("email로 유저정보 조회")
    void findByEmail(String email) {
        UsersDto usersDto = usersRepository.findByEmail(email);
        assertThat(usersDto.getEmail()).isEqualTo(email);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "AAA", "AAA@naver.com", " ", ""})
    @DisplayName("존재하지 않는 email로 유저정보 조회시 null 리턴")
    void findByEmail_NotExist_ReturnNull(String email) {
        UsersDto usersDto = usersRepository.findByEmail(email);
        assertThat(usersDto).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "BBB", "CCC", "DDD"})
    @DisplayName("nickname으로 유저정보 조회")
    void findByNickname(String nickname) {
        UsersDto usersDto = usersRepository.findByNickname(nickname);
        assertThat(usersDto.getNickname()).isEqualTo(nickname);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "AAA@gmail.com", "aaa", " ", ""})
    @DisplayName("존재하지 않는 nickname으로 유저정보 조회시 null 리턴")
    void findByNickname_NotExist_ReturnNull(String nickname) {
        UsersDto usersDto = usersRepository.findByNickname(nickname);
        assertThat(usersDto).isNull();
    }

    @Test
    @DisplayName("새로운 유저 추가")
    void save() {
        UsersDto usersDto = new UsersDto("무", "EEE", "EEE@gmail.com", "010-5555-5555",
                "대전", "EEE258", "2580");
        UsersDto savedUsersDto = usersRepository.save(usersDto);
        log.info("추가된 유저 정보: {}", savedUsersDto);
        assertThat(savedUsersDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("새로운 유저를 추가하고 정보가 정상적으로 조회되는지 테스트")
    void save_saveNewUserThenFind_isNotNull() {
        UsersDto usersDto = new UsersDto("기", "FFF", "FFF@gmail.com", "010-6666-6666",
                "대구", "FFF147", "1470");
        UsersDto savedUsersDto = usersRepository.save(usersDto);
        UsersDto findUsersDto = usersRepository.findByLoginId("FFF147");
        assertThat(savedUsersDto).usingRecursiveComparison().isEqualTo(findUsersDto);
    }
}