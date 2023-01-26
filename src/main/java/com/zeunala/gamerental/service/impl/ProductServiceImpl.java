package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.repository.ProductRepository;
import com.zeunala.gamerental.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Integer getCount() {
        return productRepository.countProductInfo();
    }

    @Override
    public Integer getCountByCategoryId(Integer categoryId) {
        return productRepository.countProductInfoByCategoryId(categoryId);
    }

    @Override
    public List<ProductInfo> getMultipleProductInfo(Integer start) {
        return productRepository.findMultipleProductInfo(start, COUNT_PER_GET_ONCE);
    }

    @Override
    public List<ProductInfo> getMultipleProductInfoByCategoryId(Integer categoryId, Integer start) {
        return productRepository.findMultipleProductInfoByCategoryId(categoryId, start, COUNT_PER_GET_ONCE);
    }

    @Override
    public ProductInfo getProductInfoByProductId(Integer productId) {
        return productRepository.findProductInfoByProductId(productId);
    }
}
