package com.zeunala.gamerental.repository.jpa;

import com.zeunala.gamerental.domain.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaPostRepository extends JpaRepository<Post, Integer> {
    @Override
    @EntityGraph(attributePaths = {"product", "product.category", "sellerUsers"})
    Optional<Post> findById(Integer id);

    @EntityGraph(attributePaths = {"product", "product.category", "sellerUsers"})
    List<Post> findByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag, Integer status);

    @EntityGraph(attributePaths = {"product", "product.category", "sellerUsers"})
    List<Post> findBySellerUsersId(Integer sellerUsersId);

    @EntityGraph(attributePaths = {"product", "product.category", "sellerUsers"})
    List<Post> findBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status);
}
