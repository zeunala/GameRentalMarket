package com.zeunala.gamerental.repository;

import com.zeunala.gamerental.dto.ProductInfo;

import java.util.List;

public interface ProductRepository {
    /**
     * 카테고리 상관 없이 총 product 수 반환
     *
     * @return 모든 product 수
     */
    Integer countProductInfo();

    /**
     * 카테고리에 해당하는 총 product 수 반환
     *
     * @param categoryId 조회할 categoryId
     * @return 해당 카테고리의 총 product 수
     */
    Integer countProductInfoByCategoryId(Integer categoryId);

    /**
     * 상품 정보를 start 번째부터 count 개수만큼 반환
     *
     * @param start 가져올 상품 정보의 시작 인덱스(0부터 시작)
     * @param count 가져올 상품 정보의 개수
     * @return start ~ start+count-1 번째의 상품 정보
     */
    List<ProductInfo> findMultipleProductInfo(Integer start, Integer count);

    /**
     * 카테고리에 해당하는 상품 정보를 start 번째부터 count 개수만큼 반환
     *
     * @param categoryId 조회할 categoryId
     * @param start      가져올 상품 정보의 시작 인덱스(0부터 시작)
     * @param count      가져올 상품 정보의 개수
     * @return 해당 카테고리의 start ~ start+count-1 번째의 상품 정보
     */
    List<ProductInfo> findMultipleProductInfoByCategoryId(Integer categoryId, Integer start, Integer count);

    /**
     * 주어진 id에 해당하는 하나의 상품 정보 반환
     *
     * @param productId 조회할 상품의 id
     * @return 해당 id를 갖는 상품 정보
     */
    ProductInfo findProductInfoByProductId(Integer productId);
}
