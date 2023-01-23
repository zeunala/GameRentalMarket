package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.Users;
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
        Users users = usersRepository.findById(id);
        log.info("{}번 유저 정보: {}", id, users);
        assertThat(users.getId()).isEqualTo(id);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA123", "BBB456", "CCC789", "DDD369"})
    @DisplayName("loginId로 유저정보 조회")
    void findByLoginId(String loginId) {
        Users users = usersRepository.findByLoginId(loginId);
        assertThat(users.getLoginId()).isEqualTo(loginId);
    }

    @Test
    @DisplayName("새로운 유저 추가")
    void save() {
        Users users = new Users("무", "EEE", "EEE@gmail.com", "010-5555-5555",
                "대전", "EEE258", "2580");
        Users savedUsers = usersRepository.save(users);
        log.info("추가된 유저 정보: {}", savedUsers);
        assertThat(savedUsers.getId()).isNotNull();
    }
    
    @Test
    @DisplayName("새로운 유저를 추가하고 정보가 정상적으로 조회되는지 테스트")
    void save_saveNewUserThenFind_isNotNull() {
        Users users = new Users("기", "FFF", "FFF@gmail.com", "010-6666-6666",
                "대구", "FFF147", "1470");
        Users savedUsers = usersRepository.save(users);
        Users findUsers = usersRepository.findByLoginId("FFF147");
        assertThat(savedUsers).usingRecursiveComparison().isEqualTo(findUsers);
    }
}