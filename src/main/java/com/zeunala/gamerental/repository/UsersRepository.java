package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.Users;

public interface UsersRepository {
    /**
     * id로 Users 테이블의 값을 가져옴
     *
     * @param id 조회할 Users의 id
     * @return 일치하는 Users 테이블의 데이터
     */
    Users findById(Integer id);

    /**
     * loginId로 Users 테이블의 값을 가져옴
     *
     * @param loginId 조회할 Users의 loginId
     * @return 일치하는 Users 테이블의 데이터
     */
    Users findByLoginId(String loginId);
}
