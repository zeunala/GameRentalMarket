package com.zeunala.gamerental.repository.impl.sql;

public class ProductRepositorySql {
    public static final String COUNT_PRODUCT_INFO = """
            SELECT COUNT(*)
            FROM product;
            """;
    public static final String COUNT_PRODUCT_INFO_BY_CATEGORY_ID = """
            SELECT COUNT(*)
            FROM product
            WHERE category_id = :categoryId;
            """;
}
