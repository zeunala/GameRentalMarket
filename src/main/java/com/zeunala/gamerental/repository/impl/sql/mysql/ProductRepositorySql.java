package com.zeunala.gamerental.repository.impl.sql.mysql;

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

    /**
     * FORMATDATETIME(product.create_date, 'yyyy-MM-dd HH:mm:ss') AS createDate 는 H2의 SQL문법으로, MySQL에서는
     * DATE_FORMAT(product.create_date, "%Y-%m-%d %H:%i:%s") AS createDate 과 같이 사용해야한다.
     * MODE=MYSQL의 호환성모드 설정으로는 DATE_FORMAT이 인식되지 않음
     */
    public static final String FIND_MULTIPLE_PRODUCT_INFO = """
            SELECT product.id AS id, product.title AS title, product.description AS description,
            	product.original_price AS originalPrice, file.path AS filePath,
            	FORMATDATETIME(product.create_date, 'yyyy-MM-dd HH:mm:ss') AS createDate,
            	(SELECT MIN(post.price)
            	FROM post
            	WHERE post.product_id = product.id AND post.rental_flag = 1 AND post.status = 0)
            	    AS minRentalPrice,
            	(SELECT MIN(post.price)
            	FROM post
            	WHERE post.product_id = product.id AND post.rental_flag = 0 AND post.status = 0)
            		AS minUsedPrice
            FROM product
            	INNER JOIN file ON product.file_id = file.id
            ORDER BY product.id ASC LIMIT :start, :count;
            """;

    /**
     * FORMATDATETIME: H2 문법
     */
    public static final String FIND_MULTIPLE_PRODUCT_INFO_BY_CATEGORY_ID = """
            SELECT product.id AS id, product.title AS title, product.description AS description,
            	product.original_price AS originalPrice, file.path AS filePath,
            	FORMATDATETIME(product.create_date, 'yyyy-MM-dd HH:mm:ss') AS createDate,
            	(SELECT MIN(post.price)
            	FROM post
            	WHERE post.product_id = product.id AND post.rental_flag = 1 AND post.status = 0)
            	    AS minRentalPrice,
            	(SELECT MIN(post.price)
            	FROM post
            	WHERE post.product_id = product.id AND post.rental_flag = 0 AND post.status = 0)
            		AS minUsedPrice
            FROM product
            	INNER JOIN file ON product.file_id = file.id
            WHERE product.category_id = :categoryId
            ORDER BY product.id ASC LIMIT :start, :count;
            """;

    /**
     * FORMATDATETIME: H2 문법
     */
    public static final String FIND_PRODUCT_INFO_BY_PRODUCT_ID = """
            SELECT product.id AS id, product.title AS title, product.description AS description,
            	product.original_price AS originalPrice, file.path AS filePath,
            	FORMATDATETIME(product.create_date, 'yyyy-MM-dd HH:mm:ss') AS createDate,
            	(SELECT MIN(post.price)
            	FROM post
            	WHERE post.product_id = product.id AND post.rental_flag = 1 AND post.status = 0)
            	    AS minRentalPrice,
            	(SELECT MIN(post.price)
            	FROM post
            	WHERE post.product_id = product.id AND post.rental_flag = 0 AND post.status = 0)
            		AS minUsedPrice
            FROM product
            	INNER JOIN file ON product.file_id = file.id
            WHERE product.id = :productId;
            """;
}
