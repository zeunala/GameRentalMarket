package com.zeunala.gamerental.repository.impl.sql;

public class PostRepositorySql {
    /**
     * FORMATDATETIME: H2 문법
     */
    public static final String FIND_POST_INFO_BY_POST_ID = """
            SELECT post.id AS id,
                (SELECT users.nickname FROM users WHERE users.id = post.seller_users_id)
                    AS sellerUsersNickname,
                post.rental_flag AS rentalFlag, post.direct_flag AS directFlag,
                category.name AS categoryName, product.title AS title,
                post.price AS price, post.extension_price AS extensionPrice,
                post.deposit AS deposit, post.comment AS comment,
                FORMATDATETIME(post.create_date, 'yyyy-MM-dd') AS createDate,
                post.status AS status
            FROM post
                INNER JOIN product ON post.product_id = product.id
                INNER JOIN category ON product.category_id = category.id
            WHERE post.id = :postId;
            """;

    /**
     * FORMATDATETIME: H2 문법
     */
    public static final String FIND_ALL_POST_INFO_BY_PRODUCT_ID_AND_RENTAL_FLAG_AND_STATUS = """
            SELECT post.id AS id,
                (SELECT users.nickname FROM users WHERE users.id = post.seller_users_id)
                    AS sellerUsersNickname,
                post.rental_flag AS rentalFlag, post.direct_flag AS directFlag,
                category.name AS categoryName, product.title AS title,
                post.price AS price, post.extension_price AS extensionPrice,
                post.deposit AS deposit, post.comment AS comment,
                FORMATDATETIME(post.create_date, 'yyyy-MM-dd') AS createDate,
                post.status AS status
            FROM post
                INNER JOIN product ON post.product_id = product.id
                INNER JOIN category ON product.category_id = category.id
            WHERE post.product_id = :productId AND post.rental_flag = :rentalFlag AND post.status = :status;
            """;

    /**
     * FORMATDATETIME: H2 문법
     */
    public static final String FIND_ALL_POST_INFO_BY_SELLER_USERS_ID_AND_STATUS = """
            SELECT post.id AS id,
                (SELECT users.nickname FROM users WHERE users.id = post.seller_users_id)
                    AS sellerUsersNickname,
                post.rental_flag AS rentalFlag, post.direct_flag AS directFlag,
                category.name AS categoryName, product.title AS title,
                post.price AS price, post.extension_price AS extensionPrice,
                post.deposit AS deposit, post.comment AS comment,
                FORMATDATETIME(post.create_date, 'yyyy-MM-dd') AS createDate,
                post.status AS status
            FROM post
                INNER JOIN product ON post.product_id = product.id
                INNER JOIN category ON product.category_id = category.id
            WHERE post.seller_users_id = :sellerUsersId AND post.status = :status;
            """;
}
