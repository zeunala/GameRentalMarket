package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.repository.UsersRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

import static com.zeunala.gamerental.repository.impl.sql.UsersRepositorySql.FIND_BY_ID;
import static com.zeunala.gamerental.repository.impl.sql.UsersRepositorySql.FIND_BY_LOGIN_ID;

@Repository
public class JdbcTemplateUsersRepository implements UsersRepository {
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert jdbcInsert;

    public JdbcTemplateUsersRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("Users")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Users findById(Integer id) {
        return jdbc.queryForObject(FIND_BY_ID, Map.of("id", id),
                BeanPropertyRowMapper.newInstance(Users.class));
    }

    @Override
    public Users findByLoginId(String loginId) {
        return jdbc.queryForObject(FIND_BY_LOGIN_ID, Map.of("loginId", loginId),
                BeanPropertyRowMapper.newInstance(Users.class));
    }

    @Override
    public Users save(Users users) {
        Number id = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(users));
        users.setId(id.intValue());
        return users;
    }
}
