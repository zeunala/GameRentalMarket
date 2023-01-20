package com.zeunala.gamerental.repository.impl.sql;

public class PromotionRepositorySql {
    public static final String FIND_ALL_PROMOTION_INFO = """
            SELECT promotion.id AS id, file.path AS filePath, promotion.url AS url
            FROM promotion
                INNER JOIN file ON promotion.file_id = file.id;
            """;
}
