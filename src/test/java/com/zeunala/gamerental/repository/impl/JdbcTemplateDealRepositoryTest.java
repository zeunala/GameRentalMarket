package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.repository.DealRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class JdbcTemplateDealRepositoryTest {
    @Autowired
    DealRepository dealRepository;

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("dealId에 해당하는 1개의 거래글 정보 확인")
    void findDealInfoByDealId(Integer dealId) {
        DealInfo dealInfo = dealRepository.findDealInfoByDealId(dealId);
        log.info("{}번 거래글 정보: {}", dealId, dealInfo);
        assertThat(dealInfo).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("sellerUsersId에 해당하는 모든 거래글 정보 확인")
    void findAllDealInfoBySellerUsersId(Integer sellerUsersId) {
        List<DealInfo> allDealInfo = dealRepository.findAllDealInfoBySellerUsersId(sellerUsersId);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,1"})
    @DisplayName("sellerUsersId, postStatus에 해당하는 모든 거래글 정보 확인")
    void findAllDealInfoBySellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus) {
        List<DealInfo> allDealInfo = dealRepository.findAllDealInfoBySellerUsersIdAndPostStatus(
                sellerUsersId, postStatus);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("buyerUsersId에 해당하는 모든 거래글 정보 확인")
    void findAllDealInfoByBuyerUsersId() {
        List<DealInfo> allDealInfo = dealRepository.findAllDealInfoByBuyerUsersId(4);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"4,1", "4,2"})
    @DisplayName("buyerUsersId, postStatus에 해당하는 모든 거래글 정보 확인")
    void findAllDealInfoByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus) {
        List<DealInfo> allDealInfo = dealRepository.findAllDealInfoByBuyerUsersIdAndPostStatus(
                buyerUsersId, postStatus);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("buyerUsersId, dealStatus에 해당하는 모든 거래글 정보 확인")
    void findAllDealInfoByBuyerUsersIdAndDealStatus() {
        List<DealInfo> allDealInfo = dealRepository.findAllDealInfoByBuyerUsersIdAndDealStatus(
                4, 0);
        assertThat(allDealInfo).isNotNull();
        assertThat(allDealInfo.size()).isEqualTo(2);
    }
}