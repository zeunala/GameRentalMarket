package com.zeunala.gamerental.repository.impl.sql;

public class DealRepositorySql {
    /**
     * FORMATDATETIME: H2 문법
     */
    private static final String COMMON_SELECT_DEAL_INFO_SQL = """
            SELECT deal.id AS id, post.id AS postId,
            	(SELECT users.nickname FROM users WHERE users.id = post.seller_users_id)
            		AS sellerUsersNickname,
            	(SELECT users.nickname FROM users WHERE users.id = deal.buyer_users_id)
            		AS buyerUsersNickName,
            	(SELECT users.home_address FROM users WHERE users.id = post.seller_users_id)
                    AS sellerUsersHomeAddress,
            	post.rental_flag AS rentalFlag, post.direct_flag AS directFlag,
            	category.name AS categoryName, product.title AS title,
            	post.price AS price, post.extension_price AS extensionPrice, deal.total_price AS totalPrice,
            	post.deposit AS deposit, post.comment AS comment,
            	FORMATDATETIME(post.create_date, 'yyyy-MM-dd HH:mm:ss') AS postCreateDate,
            	FORMATDATETIME(deal.create_date, 'yyyy-MM-dd HH:mm:ss') AS dealCreateDate,
            	post.status AS postStatus,
            	deal.status AS dealStatus
            FROM post
            	INNER JOIN product ON post.product_id = product.id
            	INNER JOIN category ON product.category_id = category.id
            	INNER JOIN deal ON deal.post_id = post.id
            """;

    public static final String FIND_DEAL_INFO_BY_DEAL_ID =
            COMMON_SELECT_DEAL_INFO_SQL + """
                    WHERE deal.id = :dealId
                    """;
    public static final String FIND_ALL_DEAL_INFO_BY_SELLER_USERS_ID =
            COMMON_SELECT_DEAL_INFO_SQL + """
                    WHERE post.seller_users_id = :sellerUsersId
                    """;
    public static final String FIND_ALL_DEAL_INFO_BY_SELLER_USERS_ID_AND_POST_STATUS =
            COMMON_SELECT_DEAL_INFO_SQL + """
                    WHERE post.seller_users_id = :sellerUsersId AND post.status = :postStatus
                    """;
    public static final String FIND_ALL_DEAL_INFO_BY_BUYER_USERS_ID =
            COMMON_SELECT_DEAL_INFO_SQL + """
                    WHERE deal.buyer_users_id = :buyerUsersId
                    """;
    public static final String FIND_ALL_DEAL_INFO_BY_BUYER_USERS_ID_AND_POST_STATUS =
            COMMON_SELECT_DEAL_INFO_SQL + """
                    WHERE deal.buyer_users_id = :buyerUsersId AND post.status = :postStatus
                    """;
    public static final String FIND_ALL_DEAL_INFO_BY_BUYER_USERS_ID_AND_DEAL_STATUS =
            COMMON_SELECT_DEAL_INFO_SQL + """
                    WHERE deal.buyer_users_id = :buyerUsersId AND deal.status = :dealStatus
                    """;

    public static final String UPDATE_STATUS_BY_ID = """
            UPDATE deal
            SET status = :status
            WHERE id = :id
            """;

    public static final String DELETE_BY_ID = """
            DELETE FROM deal
            WHERE id = :id;
            """;
}
