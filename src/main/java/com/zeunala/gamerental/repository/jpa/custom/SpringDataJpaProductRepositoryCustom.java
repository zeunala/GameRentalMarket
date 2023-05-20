package com.zeunala.gamerental.repository.jpa.custom;

import com.zeunala.gamerental.dto.ProductInfo;

import java.util.List;

public interface SpringDataJpaProductRepositoryCustom {
    List<ProductInfo> findMultipleProductInfo(Integer start, Integer count);
    List<ProductInfo> findMultipleProductInfoByCategoryId(Integer categoryId, Integer start, Integer count);
    ProductInfo findProductInfoByProductId(Integer productId);
}
