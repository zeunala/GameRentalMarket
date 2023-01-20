package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.PromotionInfo;
import com.zeunala.gamerental.repository.PromotionRepository;
import com.zeunala.gamerental.repository.impl.sql.PromotionRepositorySql;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static com.zeunala.gamerental.repository.impl.sql.PromotionRepositorySql.FIND_ALL_PROMOTION_INFO;

@Repository
public class JdbcTemplatePromotionRepository implements PromotionRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public JdbcTemplatePromotionRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<PromotionInfo> findAllPromotionInfo() {
        return jdbc.query(FIND_ALL_PROMOTION_INFO, BeanPropertyRowMapper.newInstance(PromotionInfo.class));
    }
}
