package com.zeunala.gamerental.repository.impl.sql;

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
}
