package com.zeunala.gamerental.service;

import com.zeunala.gamerental.dto.PromotionInfo;

import java.util.List;

public interface PromotionService {
    /**
     * 현재 존재하는 모든 프로모션 정보를 반환
     *
     * @return 현재 DB에 있는 모든 프로모션 정보
     */
    List<PromotionInfo> getAllPromotionInfo();
}
