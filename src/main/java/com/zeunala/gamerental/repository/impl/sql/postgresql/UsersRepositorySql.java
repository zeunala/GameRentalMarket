package com.zeunala.gamerental.repository.impl.sql.postgresql;

public class UsersRepositorySql {
    public static final String FIND_BY_ID = """
            SELECT *
            FROM users
            WHERE id = :id;
            """;

    public static final String FIND_BY_LOGIN_ID = """
            SELECT *
            FROM users
            WHERE login_id = :loginId;
            """;

    public static final String FIND_BY_EMAIL = """
            SELECT *
            FROM users
            WHERE email = :email;
            """;

    public static final String FIND_BY_NICKNAME = """
            SELECT *
            FROM users
            WHERE nickname = :nickname;
            """;
}
