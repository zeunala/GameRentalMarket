package com.zeunala.gamerental.service;

import com.zeunala.gamerental.dto.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     * 한번 조회시마다 가져올 product 수
     */
    Integer COUNT_PER_GET_ONCE = 8;
    
    /**
     * 카테고리 상관 없이 총 product 수 반환
     *
     * @return 모든 product 수
     */
    Integer getCount();

    /**
     * 카테고리에 해당하는 총 product 수 반환
     *
     * @param categoryId 조회할 categoryId
     * @return 해당 카테고리의 총 product 수
     */
    Integer getCountByCategoryId(Integer categoryId);

    /**
     * 상품 정보를 start 번째부터 정해진 개수만큼 반환
     *
     * @param start 가져올 상품 정보의 시작 인덱스(0부터 시작)
     * @return start 번째부터의 상품 정보들
     */
    List<ProductInfo> getMultipleProductInfo(Integer start);

    /**
     * 카테고리에 해당하는 상품 정보를 start 번째부터 정해진 개수만큼 반환
     *
     * @param categoryId 조회할 categoryId
     * @param start      가져올 상품 정보의 시작 인덱스(0부터 시작)
     * @return 해당 카테고리의 start 번째 부터의 상품 정보들
     */
    List<ProductInfo> getMultipleProductInfoByCategoryId(Integer categoryId, Integer start);

    /**
     * 주어진 id에 해당하는 하나의 상품 정보 반환
     *
     * @param productId 조회할 상품의 id
     * @return 해당 id를 갖는 상품 정보 (없을 경우 null)
     */
    ProductInfo getProductInfoByProductId(Integer productId);
}
