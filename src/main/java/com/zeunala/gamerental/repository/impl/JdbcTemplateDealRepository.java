package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.repository.DealRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static com.zeunala.gamerental.repository.impl.sql.DealRepositorySql.*;

@Repository
public class JdbcTemplateDealRepository implements DealRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public JdbcTemplateDealRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public DealInfo findDealInfoByDealId(Integer dealId) {
        return jdbc.queryForObject(FIND_DEAL_INFO_BY_DEAL_ID,
                Map.of("dealId", dealId), BeanPropertyRowMapper.newInstance(DealInfo.class));
    }

    @Override
    public List<DealInfo> findAllDealInfoBySellerUsersId(Integer sellerUsersId) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("sellerUsersId", sellerUsersId);

        return jdbc.query(FIND_ALL_DEAL_INFO_BY_SELLER_USERS_ID,
                sqlParam, BeanPropertyRowMapper.newInstance(DealInfo.class));
    }

    @Override
    public List<DealInfo> findAllDealInfoBySellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("sellerUsersId", sellerUsersId)
                .addValue("postStatus", postStatus);

        return jdbc.query(FIND_ALL_DEAL_INFO_BY_SELLER_USERS_ID_AND_POST_STATUS,
                sqlParam, BeanPropertyRowMapper.newInstance(DealInfo.class));
    }

    @Override
    public List<DealInfo> findAllDealInfoByBuyerUsersId(Integer buyerUsersId) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("buyerUsersId", buyerUsersId);

        return jdbc.query(FIND_ALL_DEAL_INFO_BY_BUYER_USERS_ID,
                sqlParam, BeanPropertyRowMapper.newInstance(DealInfo.class));
    }

    @Override
    public List<DealInfo> findAllDealInfoByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("buyerUsersId", buyerUsersId)
                .addValue("postStatus", postStatus);

        return jdbc.query(FIND_ALL_DEAL_INFO_BY_BUYER_USERS_ID_AND_POST_STATUS,
                sqlParam, BeanPropertyRowMapper.newInstance(DealInfo.class));
    }

    @Override
    public List<DealInfo> findAllDealInfoByBuyerUsersIdAndDealStatus(Integer buyerUsersId, Integer dealStatus) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("buyerUsersId", buyerUsersId)
                .addValue("dealStatus", dealStatus);

        return jdbc.query(FIND_ALL_DEAL_INFO_BY_BUYER_USERS_ID_AND_DEAL_STATUS,
                sqlParam, BeanPropertyRowMapper.newInstance(DealInfo.class));
    }
}
