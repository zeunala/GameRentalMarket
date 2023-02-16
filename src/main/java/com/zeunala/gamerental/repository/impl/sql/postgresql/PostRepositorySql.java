package com.zeunala.gamerental.repository.impl.sql.postgresql;

public class PostRepositorySql {
    private static final String COMMON_SELECT_POST_INFO_SQL = """
            SELECT post.id AS id,
                (SELECT users.nickname FROM users WHERE users.id = post.seller_users_id)
                    AS sellerUsersNickname,
                (SELECT users.home_address FROM users WHERE users.id = post.seller_users_id)
                    AS sellerUsersHomeAddress,
                post.rental_flag AS rentalFlag, post.direct_flag AS directFlag,
                category.name AS categoryName, product.title AS title,
                post.price AS price, post.extension_price AS extensionPrice,
                post.deposit AS deposit, post.comment AS comment,
                to_char(post.create_date, 'yyyy-MM-dd HH24:MI:SS') AS createDate,
                post.status AS status
            FROM post
                INNER JOIN product ON post.product_id = product.id
                INNER JOIN category ON product.category_id = category.id
            """;
    public static final String FIND_POST_INFO_BY_POST_ID =
            COMMON_SELECT_POST_INFO_SQL + """
                    WHERE post.id = :postId;
                    """;

    public static final String FIND_ALL_POST_INFO_BY_PRODUCT_ID_AND_RENTAL_FLAG_AND_STATUS =
            COMMON_SELECT_POST_INFO_SQL + """
                    WHERE post.product_id = :productId AND post.rental_flag = :rentalFlag AND post.status = :status;
                    """;

    public static final String FIND_ALL_POST_INFO_BY_SELLER_USERS_ID =
            COMMON_SELECT_POST_INFO_SQL + """
                    WHERE post.seller_users_id = :sellerUsersId;
                    """;
    public static final String FIND_ALL_POST_INFO_BY_SELLER_USERS_ID_AND_STATUS =
            COMMON_SELECT_POST_INFO_SQL + """
                    WHERE post.seller_users_id = :sellerUsersId AND post.status = :status;
                    """;

    public static final String UPDATE_STATUS_BY_ID = """
            UPDATE post
            SET status = :status
            WHERE id = :id;
            """;

    public static final String DELETE_BY_ID = """
            DELETE FROM post
            WHERE id = :id;
            """;
}
