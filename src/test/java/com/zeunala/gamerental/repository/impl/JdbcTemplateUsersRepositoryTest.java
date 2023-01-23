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

import static org.assertj.core.api.Assertions.assertThat;

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
}