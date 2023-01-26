package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.Users;

public interface UsersRepository {
    /**
     * id로 Users 테이블의 값을 가져옴
     *
     * @param id 조회할 Users의 id
     * @return 일치하는 Users 테이블의 데이터 (없을 경우 null)
     */
    Users findById(Integer id);

    /**
     * loginId로 Users 테이블의 값을 가져옴
     *
     * @param loginId 조회할 Users의 loginId
     * @return 일치하는 Users 테이블의 데이터 (없을 경우 null)
     */
    Users findByLoginId(String loginId);

    /**
     * Users 테이블에 새로운 데이터 추가
     *
     * @param users 추가할 데이터(id값은 DB에서 지정)
     * @return 자동 생성된 id값을 포함한 추가된 데이터
     */
    Users save(Users users);
}
