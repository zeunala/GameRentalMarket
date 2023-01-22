package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.PostInfo;

import java.util.List;

public interface PostRepository {
    /**
     * 주어진 id에 해당하는 판매글 정보 반환
     *
     * @param postId 조회할 판매글의 id
     * @return 해당 id를 갖는 판매글 정보
     */
    PostInfo findPostInfoByPostId(Integer postId);

    /**
     * 상품 id와 렌탈여부, status 값이 일치하는 모든 판매글 정보 반환
     *
     * @param productId  상품 id 조건
     * @param rentalFlag 렌탈 여부조건 (렌탈일 경우 1, 직거래일 경우 0)
     * @param status     상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return 해당 조건들이 모두 일치하는 판매글 정보 목록
     */
    List<PostInfo> findAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag,
                                                                    Integer status);

    /**
     * 판매자 id가 일치하는 모든 판매글 정보 반환
     *
     * @param sellerUsersId 판매자 id 조건
     * @return 해당 판매자 id의 모든 판매글 정보 목록
     */
    List<PostInfo> findAllPostInfoBySellerUsersId(Integer sellerUsersId);

    /**
     * 판매자 id, status 값이 일치하는 모든 판매글 정보 반환
     *
     * @param sellerUsersId 판매자 id 조건
     * @param status        상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return 해당 조건들이 모두 일치하는 판매글 정보 목록
     */
    List<PostInfo> findAllPostInfoBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status);
}
