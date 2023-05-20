package com.zeunala.gamerental.repository.jpa.custom.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zeunala.gamerental.domain.Product;
import com.zeunala.gamerental.dto.ProductInfo;
import com.zeunala.gamerental.repository.jpa.custom.SpringDataJpaProductRepositoryCustom;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.zeunala.gamerental.domain.QFile.file;
import static com.zeunala.gamerental.domain.QPost.post;
import static com.zeunala.gamerental.domain.QProduct.product;

public class SpringDataJpaProductRepositoryCustomImpl implements SpringDataJpaProductRepositoryCustom {
    EntityManager em;
    JPAQueryFactory queryFactory;

    public SpringDataJpaProductRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductInfo> findMultipleProductInfo(Integer start, Integer count) {
        return getProductInfoQuery()
                .offset(start)
                .limit(count)
                .fetch();
    }

    @Override
    public List<ProductInfo> findMultipleProductInfoByCategoryId(Integer categoryId, Integer start, Integer count) {
        return getProductInfoQuery()
                .where(product.category.id.eq(categoryId))
                .offset(start)
                .limit(count)
                .fetch();
    }

    @Override
    public ProductInfo findProductInfoByProductId(Integer productId) {
        return getProductInfoQuery()
                .where(product.id.eq(productId))
                .fetchOne();
    }

    private JPAQuery<ProductInfo> getProductInfoQuery() {
        JPAQuery<ProductInfo> productInfoQuery = queryFactory.select(Projections.constructor(ProductInfo.class,
                                Projections.constructor(Product.class,
                                        product.id,
                                        product.category,
                                        product.title,
                                        product.description,
                                        product.originalPrice,
                                        product.file,
                                        product.createDate
                                ),
                                JPAExpressions.select(post.price.min())
                                        .from(post)
                                        .where(post.product.eq(product)
                                                .and(post.rentalFlag.eq(1))
                                                .and(post.status.eq(0))
                                        ),
                                JPAExpressions.select(post.price.min())
                                        .from(post)
                                        .where(post.product.eq(product)
                                                .and(post.rentalFlag.eq(0))
                                                .and(post.status.eq(0))
                                        )
                        )
                )
                .from(product)
                .join(product.file, file);
        return productInfoQuery;
    }
}
