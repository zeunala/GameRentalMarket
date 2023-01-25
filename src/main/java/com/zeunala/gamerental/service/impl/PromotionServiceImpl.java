package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.PromotionInfo;
import com.zeunala.gamerental.repository.PromotionRepository;
import com.zeunala.gamerental.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Override
    public List<PromotionInfo> getAllPromotionInfo() {
        return promotionRepository.findAllPromotionInfo();
    }
}
