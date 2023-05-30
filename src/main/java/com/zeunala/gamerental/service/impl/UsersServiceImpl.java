package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.UsersDto;
import com.zeunala.gamerental.repository.UsersRepository;
import com.zeunala.gamerental.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsersDto getUsersById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public UsersDto getUsersByLoginId(String loginId) {
        return usersRepository.findByLoginId(loginId);
    }

    @Override
    public UsersDto getUsersByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public UsersDto getUsersByNickname(String nickname) {
        return usersRepository.findByNickname(nickname);
    }

    @Override
    @Transactional
    public UsersDto registerUsers(UsersDto usersDto) throws IllegalArgumentException {
        usersDto.setLoginPassword(passwordEncoder.encode(usersDto.getLoginPassword()));
        try {
            return usersRepository.save(usersDto);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 존재하는 값이 입력되었습니다.", e);
        }
    }

    @Override
    public Boolean login(String loginId, String loginPassword) {
        UsersDto usersDto = usersRepository.findByLoginId(loginId);
        return usersDto != null && passwordEncoder.matches(loginPassword, usersDto.getLoginPassword());
    }
}
