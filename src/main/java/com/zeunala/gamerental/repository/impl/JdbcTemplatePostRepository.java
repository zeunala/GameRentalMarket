package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.repository.PostRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static com.zeunala.gamerental.repository.impl.sql.PostRepositorySql.*;

@Repository
public class JdbcTemplatePostRepository implements PostRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public JdbcTemplatePostRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public PostInfo findPostInfoByPostId(Integer postId) {
        return jdbc.queryForObject(FIND_POST_INFO_BY_POST_ID,
                Map.of("postId", postId), BeanPropertyRowMapper.newInstance(PostInfo.class));
    }

    @Override
    public List<PostInfo> findAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag,
                                                                           Integer status) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("productId", productId)
                .addValue("rentalFlag", rentalFlag)
                .addValue("status", status);

        return jdbc.query(FIND_ALL_POST_INFO_BY_PRODUCT_ID_AND_RENTAL_FLAG_AND_STATUS,
                sqlParam, BeanPropertyRowMapper.newInstance(PostInfo.class));
    }

    @Override
    public List<PostInfo> findAllPostInfoBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("sellerUsersId", sellerUsersId)
                .addValue("status", status);

        return jdbc.query(FIND_ALL_POST_INFO_BY_SELLER_USERS_ID_AND_STATUS,
                sqlParam, BeanPropertyRowMapper.newInstance(PostInfo.class));
    }
}
