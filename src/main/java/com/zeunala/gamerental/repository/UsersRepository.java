package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.UsersDto;

public interface UsersRepository {
    /**
     * id로 Users 테이블의 값을 가져옴
     *
     * @param id 조회할 Users의 id
     * @return 일치하는 Users 테이블의 데이터 (없을 경우 null)
     */
    UsersDto findById(Integer id);

    /**
     * loginId로 Users 테이블의 값을 가져옴
     *
     * @param loginId 조회할 Users의 loginId
     * @return 일치하는 Users 테이블의 데이터 (없을 경우 null)
     */
    UsersDto findByLoginId(String loginId);

    /**
     * email로 Users 테이블의 값을 가져옴
     *
     * @param email 조회할 Users의 email
     * @return 일치하는 Users 테이블의 데이터 (없을 경우 null)
     */
    UsersDto findByEmail(String email);

    /**
     * nickname으로 Users 테이블의 값을 가져옴
     *
     * @param nickname 조회할 Users의 nickname
     * @return 일치하는 Users 테이블의 데이터 (없을 경우 null)
     */
    UsersDto findByNickname(String nickname);

    /**
     * Users 테이블에 새로운 데이터 추가
     *
     * @param usersDto 추가할 데이터(id값은 DB에서 지정)
     * @return 자동 생성된 id값을 포함한 추가된 데이터
     */
    UsersDto save(UsersDto usersDto);
}
