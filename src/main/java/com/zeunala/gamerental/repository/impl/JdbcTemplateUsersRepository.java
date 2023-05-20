package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.UsersDto;
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
    public UsersDto findById(Integer id) {
        try {
            return jdbc.queryForObject(FIND_BY_ID, Map.of("id", id),
                    BeanPropertyRowMapper.newInstance(UsersDto.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public UsersDto findByLoginId(String loginId) {
        try {
            return jdbc.queryForObject(FIND_BY_LOGIN_ID, Map.of("loginId", loginId),
                    BeanPropertyRowMapper.newInstance(UsersDto.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public UsersDto findByEmail(String email) {
        try {
            return jdbc.queryForObject(FIND_BY_EMAIL, Map.of("email", email),
                    BeanPropertyRowMapper.newInstance(UsersDto.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public UsersDto findByNickname(String nickname) {
        try {
            return jdbc.queryForObject(FIND_BY_NICKNAME, Map.of("nickname", nickname),
                    BeanPropertyRowMapper.newInstance(UsersDto.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public UsersDto save(UsersDto usersDto) {
        Number id = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(usersDto));
        usersDto.setId(id.intValue());
        return usersDto;
    }
}
