package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.DealDto;
import com.zeunala.gamerental.dto.DealInfo;

import java.util.List;

public interface DealRepository {
    /**
     * 주어진 id에 해당하는 거래글 정보 반환
     *
     * @param dealId 조회할 거래글의 id
     * @return 해당 id를 갖는 거래글 정보 (없을 경우 null)
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
     * @param dealStatus   거래 상태 조건 (0~4)
     * @return 해당 조건들이 모두 일치하는 모든 거래글 정보 목록
     */
    List<DealInfo> findAllDealInfoByBuyerUsersIdAndDealStatus(Integer buyerUsersId, Integer dealStatus);

    /**
     * deal 테이블에 새로운 데이터 추가
     *
     * @param dealDto 추가할 데이터(id값은 DB에서 지정)
     * @return 자동 생성된 id값을 포함한 추가된 데이터
     */
    DealDto save(DealDto dealDto);

    /**
     * deal 테이블에서 id로 행을 찾아 status 값을 변경
     *
     * @param id     변경할 행의 id
     * @param status 바꿀 status 값
     * @return 변경 성공시 true, 실패시 false 반환
     */
    Boolean updateStatusById(Integer id, Integer status);

    /**
     * deal 테이블에서 id가 일치하는 데이터 삭제
     *
     * @param id 삭제할 행의 id
     * @return 삭제 성공시 true, 실패시 false 반환
     */
    Boolean deleteById(Integer id);
}
