package com.zeunala.gamerental.repository.jpa;

import com.zeunala.gamerental.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaUsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByLoginId(String loginId);
    Optional<Users> findByEmail(String email);
    Optional<Users> findByNickname(String nickname);
}
