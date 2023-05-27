package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.domain.Post;
import com.zeunala.gamerental.domain.Product;
import com.zeunala.gamerental.domain.Users;
import com.zeunala.gamerental.dto.PostDto;
import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.repository.PostRepository;
import com.zeunala.gamerental.repository.jpa.SpringDataJpaPostRepository;
import com.zeunala.gamerental.util.PostStatus;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
@Transactional
@RequiredArgsConstructor
public class JpaPostRepository implements PostRepository {
    private final SpringDataJpaPostRepository repository;
    private final EntityManager em;

    @Override
    public PostInfo findPostInfoByPostId(Integer postId) {
        return repository.findById(postId).map(PostInfo::new).orElse(null);
    }

    @Override
    public List<PostInfo> findAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag, Integer status) {
        return repository.findByProductIdAndRentalFlagAndStatus(productId, rentalFlag, status)
                .stream().map(PostInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<PostInfo> findAllPostInfoBySellerUsersId(Integer sellerUsersId) {
        return repository.findBySellerUsersId(sellerUsersId)
                .stream().map(PostInfo::new).collect(Collectors.toList());
    }

    @Override
    public List<PostInfo> findAllPostInfoBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status) {
        return repository.findBySellerUsersIdAndStatus(sellerUsersId, status)
                .stream().map(PostInfo::new).collect(Collectors.toList());
    }

    @Override
    public PostDto save(PostDto postDto) {
        Post post = new Post(null,
                em.find(Product.class, postDto.getProductId()),
                em.find(Users.class, postDto.getSellerUsersId()),
                postDto.getRentalFlag(),
                postDto.getDirectFlag(),
                postDto.getPrice(),
                postDto.getExtensionPrice(),
                postDto.getDeposit(),
                postDto.getComment(),
                LocalDateTime.now(),
                PostStatus.REGISTERING_POST);
        PostDto result = new PostDto(repository.save(post));
        return result;
    }

    @Override
    public Boolean updateStatusById(Integer id, Integer status) {
        Post post = em.find(Post.class, id);
        if (post == null) {
            return false;
        }

        post.setStatus(status);
        em.flush(); // DealServiceImpl에서 JdbcTemplateDealRepository와 같이 호출되므로 임시로 flush 호출
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
