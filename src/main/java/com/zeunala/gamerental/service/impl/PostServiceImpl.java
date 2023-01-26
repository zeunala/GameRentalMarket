package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.Post;
import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.repository.PostRepository;
import com.zeunala.gamerental.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostInfo getPostInfoByPostId(Integer postId) {
        return postRepository.findPostInfoByPostId(postId);
    }

    @Override
    public List<PostInfo> getAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag,
                                                                          Integer status) {
        return postRepository.findAllPostInfoByProductIdAndRentalFlagAndStatus(productId, rentalFlag, status);
    }

    @Override
    public List<PostInfo> getAllPostInfoBySellerUsersId(Integer sellerUsersId) {
        return postRepository.findAllPostInfoBySellerUsersId(sellerUsersId);
    }

    @Override
    public List<PostInfo> getAllPostInfoBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status) {
        return postRepository.findAllPostInfoBySellerUsersIdAndStatus(sellerUsersId, status);
    }

    @Override
    public Post registerPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Boolean changeStatusById(Integer id, Integer status) {
        return postRepository.updateStatusById(id, status);
    }
}
