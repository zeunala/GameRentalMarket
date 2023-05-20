package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.repository.ProductRepository;
import com.zeunala.gamerental.repository.jpa.SpringDataJpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Primary
@Repository
@Transactional
@RequiredArgsConstructor
public class JpaProductRepository implements ProductRepository {
    private final SpringDataJpaProductRepository repository;

    @Override
    public Integer countProductInfo() {
        return Math.toIntExact(repository.count());
    }

    @Override
    public Integer countProductInfoByCategoryId(Integer categoryId) {
        return Math.toIntExact(repository.countProductByCategoryId(categoryId));
    }

    @Override
    public List<ProductInfo> findMultipleProductInfo(Integer start, Integer count) {
        return repository.findMultipleProductInfo(start, count);
    }

    @Override
    public List<ProductInfo> findMultipleProductInfoByCategoryId(Integer categoryId, Integer start, Integer count) {
        return repository.findMultipleProductInfoByCategoryId(categoryId, start, count);
    }

    @Override
    public ProductInfo findProductInfoByProductId(Integer productId) {
        return repository.findProductInfoByProductId(productId);
    }
}
