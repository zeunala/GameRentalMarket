package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.PromotionInfo;
import com.zeunala.gamerental.repository.PromotionRepository;
import com.zeunala.gamerental.service.PromotionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class PromotionServiceImplTest {
    @Autowired
    PromotionService promotionService;

    @Test
    @DisplayName("프로모션이 1개이상 정상 조회되는지 확인")
    void getAllPromotionInfo() {
        List<PromotionInfo> result = promotionService.getAllPromotionInfo();
        log.info("프로모션 조회: {}", result);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }
}