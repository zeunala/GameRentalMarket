package com.zeunala.gamerental.repository.jpa;

import com.zeunala.gamerental.domain.Deal;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaDealRepository extends JpaRepository<Deal, Integer> {
    @Override
    @EntityGraph(attributePaths = {"post", "post.product", "post.product.category", "post.sellerUsers", "buyerUsers"})
    Optional<Deal> findById(Integer id);

    @EntityGraph(attributePaths = {"post", "post.product", "post.product.category", "post.sellerUsers", "buyerUsers"})
    List<Deal> findByPostSellerUsersId(Integer sellerUsersId);

    @EntityGraph(attributePaths = {"post", "post.product", "post.product.category", "post.sellerUsers", "buyerUsers"})
    List<Deal> findByPostSellerUsersIdAndPostStatus(Integer sellerUsersId, Integer postStatus);

    @EntityGraph(attributePaths = {"post", "post.product", "post.product.category", "post.sellerUsers", "buyerUsers"})
    List<Deal> findByBuyerUsersId(Integer buyerUsersId);

    @EntityGraph(attributePaths = {"post", "post.product", "post.product.category", "post.sellerUsers", "buyerUsers"})
    List<Deal> findByBuyerUsersIdAndPostStatus(Integer buyerUsersId, Integer postStatus);

    @EntityGraph(attributePaths = {"post", "post.product", "post.product.category", "post.sellerUsers", "buyerUsers"})
    List<Deal> findByBuyerUsersIdAndStatus(Integer buyerUsersId, Integer dealStatus);
}
