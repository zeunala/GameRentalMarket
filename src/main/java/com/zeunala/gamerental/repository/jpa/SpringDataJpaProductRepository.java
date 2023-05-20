package com.zeunala.gamerental.repository.jpa;

import com.zeunala.gamerental.domain.Product;
import com.zeunala.gamerental.repository.jpa.custom.SpringDataJpaProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaProductRepository extends JpaRepository<Product, Integer>, SpringDataJpaProductRepositoryCustom {
    long countProductByCategoryId(Integer categoryId);
}
