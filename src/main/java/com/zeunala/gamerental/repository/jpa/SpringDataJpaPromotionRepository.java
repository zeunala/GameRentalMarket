package com.zeunala.gamerental.repository.jpa;

import com.zeunala.gamerental.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaPromotionRepository extends JpaRepository<Promotion, Integer> {
}
