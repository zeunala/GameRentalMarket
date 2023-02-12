package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.Post;
import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.repository.PostRepository;
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

import static com.zeunala.gamerental.repository.impl.sql.PostRepositorySql.*;
import static com.zeunala.gamerental.repository.impl.sql.UsersRepositorySql.FIND_BY_ID;

@Repository
public class JdbcTemplatePostRepository implements PostRepository {
    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert jdbcInsert;

    public JdbcTemplatePostRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("post")
                .usingGeneratedKeyColumns("id", "create_date", "status");
    }

    @Override
    public PostInfo findPostInfoByPostId(Integer postId) {
        try {
            return jdbc.queryForObject(FIND_POST_INFO_BY_POST_ID,
                    Map.of("postId", postId), BeanPropertyRowMapper.newInstance(PostInfo.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
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
    public List<PostInfo> findAllPostInfoBySellerUsersId(Integer sellerUsersId) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("sellerUsersId", sellerUsersId);

        return jdbc.query(FIND_ALL_POST_INFO_BY_SELLER_USERS_ID,
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

    @Override
    public Post save(Post post) {
        KeyHolder keyholder = jdbcInsert.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(post));
        post.setId((Integer)keyholder.getKeys().get("id"));
        post.setCreateDate(keyholder.getKeys().get("create_date").toString().substring(0, 10));
        post.setStatus((Integer)keyholder.getKeys().get("status"));
        return post;
    }

    @Override
    public Boolean updateStatusById(Integer id, Integer status) {
        SqlParameterSource sqlParam = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("status", status);

        Integer result = jdbc.update(UPDATE_STATUS_BY_ID, sqlParam);

        return result > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Integer result = jdbc.update(DELETE_BY_ID, Map.of("id", id));

        return result > 0;
    }
}
