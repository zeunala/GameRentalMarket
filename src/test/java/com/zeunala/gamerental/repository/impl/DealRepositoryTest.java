package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.DealDto;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
class DealRepositoryTest {
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
    @ValueSource(ints = {11111111, 22222222, -1})
    @DisplayName("존재하지 않는 dealId의 거래글 정보 확인시 null 리턴")
    void findDealInfoByDealId_NotExist_ReturnNull(Integer dealId) {
        assertThat(dealRepository.findDealInfoByDealId(dealId)).isNull();
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

    @Test
    @DisplayName("새로운 거래글 추가")
    void save() {
        DealDto dealDto = new DealDto(1, 2, 6900);
        DealDto savedDealDto = dealRepository.save(dealDto);
        log.info("추가된 거래글: {}", savedDealDto);
        assertThat(savedDealDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("새로운 거래글을 추가하고 정보가 정상적으로 조회되는지 테스트")
    void save_SaveDealThenFind_IsNotNull() {
        DealDto dealDto = new DealDto(1, 3, 8400);
        DealDto savedDealDto = dealRepository.save(dealDto);
        DealInfo findDealInfo = dealRepository.findDealInfoByDealId(savedDealDto.getId());
        log.info("조회된 거래글 정보: {}", findDealInfo);
        assertThat(findDealInfo).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,1,true", "2,2,true", "99999,2,false"})
    @DisplayName("status 값을 바꾸고 변경값 확인")
    void updateStatusById(Integer id, Integer status, Boolean expected) {
        Boolean updateResult = dealRepository.updateStatusById(id, status);
        assertThat(updateResult).isEqualTo(expected);
        if (updateResult) {
            assertThat(dealRepository.findDealInfoByDealId(id).getDealStatus()).isEqualTo(status);
        }
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "100,false", "-1,false"})
    @DisplayName("거래글 삭제시 삭제유무를 리턴하고 정보가 조회되지 않는지 테스트")
    void deleteById(Integer id, Boolean expected) {
        assertThat(dealRepository.deleteById(id)).isEqualTo(expected);
        assertThat(dealRepository.findDealInfoByDealId(id)).isNull();
    }
}