package com.zeunala.gamerental.service;

import com.zeunala.gamerental.dto.Post;
import com.zeunala.gamerental.dto.PostInfo;

import java.util.List;

public interface PostService {
    /**
     * 주어진 id에 해당하는 판매글 정보 반환
     *
     * @param postId 조회할 판매글의 id
     * @return 해당 id를 갖는 판매글 정보 (없을 경우 null)
     */
    PostInfo getPostInfoByPostId(Integer postId);

    /**
     * 상품 id와 렌탈여부, status 값이 일치하는 모든 판매글 정보 반환
     *
     * @param productId  상품 id 조건
     * @param rentalFlag 렌탈 여부조건 (렌탈일 경우 1, 직거래일 경우 0)
     * @param status     상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return 해당 조건들이 모두 일치하는 판매글 정보 목록
     */
    List<PostInfo> getAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag,
                                                                    Integer status);

    /**
     * 판매자 id가 일치하는 모든 판매글 정보 반환
     *
     * @param sellerUsersId 판매자 id 조건
     * @return 해당 판매자 id의 모든 판매글 정보 목록
     */
    List<PostInfo> getAllPostInfoBySellerUsersId(Integer sellerUsersId);

    /**
     * 판매자 id, status 값이 일치하는 모든 판매글 정보 반환
     *
     * @param sellerUsersId 판매자 id 조건
     * @param status        상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return 해당 조건들이 모두 일치하는 판매글 정보 목록
     */
    List<PostInfo> getAllPostInfoBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status);

    /**
     * 새로운 post 데이터 추가
     *
     * @param post 추가할 데이터(id값은 DB에서 지정)
     * @return 자동 생성된 id값을 포함한 추가된 데이터
     */
    Post registerPost(Post post);

    /**
     * id가 일치하는 post의 status 값을 변경
     *
     * @param id     변경할 행의 id
     * @param status 바꿀 status 값
     * @return 변경 성공시 true, 실패시 false 반환
     */
    Boolean changeStatusById(Integer id, Integer status);
}
