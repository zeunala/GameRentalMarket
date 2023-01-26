package com.zeunala.gamerental.service;

import com.zeunala.gamerental.dto.Users;

public interface UsersService {
    /**
     * 주어진 id에 해당하는 유저 정보 반환
     *
     * @param id 조회할 유저의 id
     * @return 해당 id를 갖는 유저 정보 (없을 경우 null)
     */
    Users getUsersById(Integer id);

    /**
     * 주어진 loginId에 해당하는 유저 정보 반환
     *
     * @param loginId 조회할 유저의 email
     * @return 해당 loginId를 갖는 유저 정보 (없을 경우 null)
     */
    Users getUsersByLoginId(String loginId);

    /**
     * 주어진 email에 해당하는 유저 정보 반환
     *
     * @param email 조회할 유저의 email
     * @return 해당 email을 갖는 유저 정보 (없을 경우 null)
     */
    Users getUsersByEmail(String email);

    /**
     * 주어진 nickname에 해당하는 유저 정보 반환
     *
     * @param nickname 조회할 유저의 nickname
     * @return 해당 nickname을 갖는 유저 정보 (없을 경우 null)
     */
    Users getUsersByNickname(String nickname);

    /**
     * 새로운 유저 데이터 추가
     *
     * @param users 추가할 데이터(id값은 DB에서 지정)
     * @return 자동 생성된 id값을 포함한 추가된 데이터
     * @throws IllegalArgumentException 잘못된 데이터 입력 (중복된 로그인아이디/닉네임/이메일 사용)
     */
    Users registerUsers(Users users);

    /**
     * 주어진 loginId/loginPassword 로 로그인 시도 후 성공 여부 반환
     *
     * @param loginId       로그인 아이디
     * @param loginPassword 로그인 패스워드
     * @return 로그인 성공 여부
     */
    Boolean login(String loginId, String loginPassword);
}
