package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.Deal;
import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
class DealServiceImplTest {
    @Autowired
    DealService dealService;

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("dealId에 해당하는 1개의 거래글 정보 확인")
    void getDealInfoByDealId(Integer dealId) {
        DealInfo dealInfo = dealService.getDealInfoByDealId(dealId);
        log.info("{}번 거래글 정보: {}", dealId, dealInfo);
        assertThat(dealInfo).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {11111111, 22222222, -1})
    @DisplayName("존재하지 않는 dealId의 거래글 정보 확인시 null 리턴")
    void findDealInfoByDealId_NotExist_ReturnNull(Integer dealId) {
        assertThat(dealService.getDealInfoByDealId(dealId)).isNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("sellerUsersId에 해당하는 모든 거래글 정보 확인")
    void getAllDealInfoBySellerUsersId(Integer sellerUsersId) {
        List<DealInfo> allDealInfo = dealService.getAllDealInfoBySellerUsersId(sellerUsersId);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,1"})
    @DisplayName("sellerUsersId, postStatus에 해당하는 모든 거래글 정보 확인")
    void getAllDealInfoBySellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus) {
        List<DealInfo> allDealInfo = dealService.getAllDealInfoBySellerUsersIdAndPostStatus(
                sellerUsersId, postStatus);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("buyerUsersId에 해당하는 모든 거래글 정보 확인")
    void getAllDealInfoByBuyerUsersId() {
        List<DealInfo> allDealInfo = dealService.getAllDealInfoByBuyerUsersId(4);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"4,1", "4,2"})
    @DisplayName("buyerUsersId, postStatus에 해당하는 모든 거래글 정보 확인")
    void getAllDealInfoByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus) {
        List<DealInfo> allDealInfo = dealService.getAllDealInfoByBuyerUsersIdAndPostStatus(
                buyerUsersId, postStatus);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("buyerUsersId, dealStatus에 해당하는 모든 거래글 정보 확인")
    void getAllDealInfoByBuyerUsersIdAndDealStatus() {
        List<DealInfo> allDealInfo = dealService.getAllDealInfoByBuyerUsersIdAndDealStatus(
                4, 0);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("새로운 거래글 추가")
    void registerDeal() {
        Deal deal = new Deal(1, 2, 6900);
        Deal savedDeal = dealService.registerDeal(deal);
        log.info("추가된 거래글: {}", savedDeal);
        assertThat(savedDeal.getId()).isNotNull();
    }

    @Test
    @DisplayName("새로운 거래글을 추가하고 정보가 정상적으로 조회되는지 테스트")
    void registerDeal_RegisterThenFind_IsNotNull() {
        Deal deal = new Deal(1, 3, 8400);
        Deal savedDeal = dealService.registerDeal(deal);
        DealInfo findDealInfo = dealService.getDealInfoByDealId(savedDeal.getId());
        log.info("조회된 거래글 정보: {}", findDealInfo);
        assertThat(findDealInfo).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,1,true", "2,2,true", "99999,2,false"})
    @DisplayName("status 값을 바꾸고 변경값 확인")
    void changeStatusById(Integer id, Integer status, Boolean expected) {
        Boolean updateResult = dealService.changeStatusById(id, status);
        assertThat(updateResult).isEqualTo(expected);
        if (updateResult) {
            assertThat(dealService.getDealInfoByDealId(id).getDealStatus()).isEqualTo(status);
        }
    }
}