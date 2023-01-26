package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.Deal;
import com.zeunala.gamerental.dto.DealInfo;
import com.zeunala.gamerental.repository.DealRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static com.zeunala.gamerental.repository.impl.sql.DealRepositorySql.*;

@Repository
public class JdbcTemplateDealRepository implements DealRepository {
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert jdbcInsert;

    public JdbcTemplateDealRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("deal")
                .usingGeneratedKeyColumns("id", "create_date", "status");
    }

    @Override
    public DealInfo findDealInfoByDealId(Integer dealId) {
        try {
            return jdbc.queryForObject(FIND_DEAL_INFO_BY_DEAL_ID,
                    Map.of("dealId", dealId), BeanPropertyRowMapper.newInstance(DealInfo.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
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

    @Override
    public Deal save(Deal deal) {
        KeyHolder keyholder = jdbcInsert.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(deal));
        deal.setId((Integer)keyholder.getKeys().get("id"));
        deal.setCreateDate(keyholder.getKeys().get("create_date").toString().substring(0, 10));
        deal.setStatus((Integer)keyholder.getKeys().get("status"));
        return deal;
    }

    @Override
    public Boolean updateStatusById(Integer id, Integer status) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("status", status);

        Integer result = jdbc.update(UPDATE_STATUS_BY_ID, sqlParam);

        return result > 0;
    }
}
