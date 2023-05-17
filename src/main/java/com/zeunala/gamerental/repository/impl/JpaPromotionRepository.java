package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.PromotionInfo;
import com.zeunala.gamerental.repository.PromotionRepository;
import com.zeunala.gamerental.repository.jpa.SpringDataJpaPromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
@Transactional
@RequiredArgsConstructor
public class JpaPromotionRepository implements PromotionRepository {
    private final SpringDataJpaPromotionRepository repository;

    @Override
    public List<PromotionInfo> findAllPromotionInfo() {
        return repository.findAll().stream().map(PromotionInfo::new).collect(Collectors.toList());
    }
}
