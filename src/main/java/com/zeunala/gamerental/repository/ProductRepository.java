package com.zeunala.gamerental.repository;

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
}
