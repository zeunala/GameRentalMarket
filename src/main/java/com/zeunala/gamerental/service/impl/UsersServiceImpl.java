package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.repository.UsersRepository;
import com.zeunala.gamerental.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users getUsersById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users getUsersByLoginId(String loginId) {
        return usersRepository.findByLoginId(loginId);
    }

    @Override
    public Users getUsersByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users getUsersByNickname(String nickname) {
        return usersRepository.findByNickname(nickname);
    }

    @Override
    @Transactional
    public Users registerUsers(Users users) throws IllegalArgumentException {
        users.setLoginPassword(passwordEncoder.encode(users.getLoginPassword()));
        try {
            return usersRepository.save(users);
        } catch (DuplicateKeyException e) {
            throw new IllegalArgumentException("이미 존재하는 값이 입력되었습니다.", e);
        }
    }

    @Override
    public Boolean login(String loginId, String loginPassword) {
        Users users = usersRepository.findByLoginId(loginId);
        return users != null && passwordEncoder.matches(loginPassword, users.getLoginPassword());
    }
}
