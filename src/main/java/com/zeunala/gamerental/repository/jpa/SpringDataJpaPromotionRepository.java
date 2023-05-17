package com.zeunala.gamerental.repository.jpa;

import com.zeunala.gamerental.domain.Promotion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Override
    @EntityGraph(attributePaths = {"file"})
    List<Promotion> findAll();
}
