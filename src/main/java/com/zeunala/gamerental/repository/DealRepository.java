package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.DealInfo;

import java.util.List;

public interface DealRepository {
    /**
     * 주어진 id에 해당하는 거래글 정보 반환
     *
     * @param dealId 조회할 거래글의 id
     * @return 해당 id를 갖는 거래글 정보
     */
    DealInfo findDealInfoByDealId(Integer dealId);

    /**
     * 판매자 id에 해당하는 모든 거래글 정보 반환
     *
     * @param sellerUsersId 판매자 id 조건
     * @return 해당 판매자 id의 모든 거래글 정보 목록
     */
    List<DealInfo> findAllDealInfoBySellerUsersId(Integer sellerUsersId);

    /**
     * 판매자 id, 판매 상태에 해당하는 모든 거래글 정보 반환
     *
     * @param sellerUsersId 판매자 id 조건
     * @param postStatus    판매글 상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return 해당 조건들이 모두 일치하는 모든 거래글 정보 목록
     */
    List<DealInfo> findAllDealInfoBySellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus);

    /**
     * 구매자 id, 판매 상태에 해당하는 모든 거래글 정보 반환
     *
     * @param buyerUsersId 구매자 id 조건
     * @return 해당 조건들이 모두 일치하는 모든 거래글 정보 목록
     */
    List<DealInfo> findAllDealInfoByBuyerUsersId(Integer buyerUsersId);

    /**
     * 구매자 id, 판매 상태에 해당하는 모든 거래글 정보 반환
     *
     * @param buyerUsersId 구매자 id 조건
     * @param postStatus   판매글 상태 조건 (대기물품 0, 거래중 1, 거래종료 2)
     * @return 해당 조건들이 모두 일치하는 모든 거래글 정보 목록
     */
    List<DealInfo> findAllDealInfoByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus);

    /**
     * 구매자 id, 거래 상태에 해당하는 모든 거래글 정보 반환
     *
     * @param buyerUsersId 구매자 id 조건
     * @param dealStatus   거래 상태 조건 (0~6)
     * @return 해당 조건들이 모두 일치하는 모든 거래글 정보 목록
     */
    List<DealInfo> findAllDealInfoByBuyerUsersIdAndDealStatus(Integer buyerUsersId, Integer dealStatus);
}
