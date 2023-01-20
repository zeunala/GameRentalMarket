package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.repository.ProductRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.Collections;
import java.util.Map;

import static com.zeunala.gamerental.repository.impl.sql.ProductRepositorySql.*;

@Repository
public class JdbcTemplateProductRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public JdbcTemplateProductRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Integer countProductInfo() {
        return jdbc.queryForObject(COUNT_PRODUCT_INFO, Collections.emptyMap(), Integer.class);
    }

    @Override
    public Integer countProductInfoByCategoryId(Integer categoryId) {
        return jdbc.queryForObject(COUNT_PRODUCT_INFO_BY_CATEGORY_ID,
                Map.of("categoryId", categoryId), Integer.class);
    }
}
