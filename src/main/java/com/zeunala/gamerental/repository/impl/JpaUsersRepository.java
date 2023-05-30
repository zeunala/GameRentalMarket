package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.domain.Users;
import com.zeunala.gamerental.dto.UsersDto;
import com.zeunala.gamerental.repository.UsersRepository;
import com.zeunala.gamerental.repository.jpa.SpringDataJpaUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Repository
@Transactional
@RequiredArgsConstructor
public class JpaUsersRepository implements UsersRepository {
    private final SpringDataJpaUsersRepository repository;

    @Override
    public UsersDto findById(Integer id) {
        return repository.findById(id).map(UsersDto::new).orElse(null);
    }

    @Override
    public UsersDto findByLoginId(String loginId) {
        return repository.findByLoginId(loginId).map(UsersDto::new).orElse(null);
    }

    @Override
    public UsersDto findByEmail(String email) {
        return repository.findByEmail(email).map(UsersDto::new).orElse(null);
    }

    @Override
    public UsersDto findByNickname(String nickname) {
        return repository.findByNickname(nickname).map(UsersDto::new).orElse(null);
    }

    @Override
    public UsersDto save(UsersDto usersDto) {
        Users users = new Users(null,
                usersDto.getName(),
                usersDto.getNickname(),
                usersDto.getEmail(),
                usersDto.getTel(),
                usersDto.getHomeAddress(),
                usersDto.getLoginId(),
                usersDto.getLoginPassword());
        UsersDto result = new UsersDto(repository.save(users));
        return result;
    }
}
