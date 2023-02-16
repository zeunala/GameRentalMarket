package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.Users;
import com.zeunala.gamerental.repository.UsersRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

import static com.zeunala.gamerental.repository.impl.sql.postgresql.UsersRepositorySql.*;

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
        try {
            return jdbc.queryForObject(FIND_BY_ID, Map.of("id", id),
                    BeanPropertyRowMapper.newInstance(Users.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Users findByLoginId(String loginId) {
        try {
            return jdbc.queryForObject(FIND_BY_LOGIN_ID, Map.of("loginId", loginId),
                    BeanPropertyRowMapper.newInstance(Users.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Users findByEmail(String email) {
        try {
            return jdbc.queryForObject(FIND_BY_EMAIL, Map.of("email", email),
                    BeanPropertyRowMapper.newInstance(Users.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Users findByNickname(String nickname) {
        try {
            return jdbc.queryForObject(FIND_BY_NICKNAME, Map.of("nickname", nickname),
                    BeanPropertyRowMapper.newInstance(Users.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Users save(Users users) {
        Number id = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(users));
        users.setId(id.intValue());
        return users;
    }
}
