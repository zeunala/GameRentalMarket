package com.zeunala.gamerental.repository.impl;

import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class JdbcTemplatePostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("1개의 판매글 정보 확인")
    void findPostInfoByPostId(Integer postId) {
        PostInfo postInfo = postRepository.findPostInfoByPostId(postId);
        log.info("{}번 판매글 정보: {}", postId, postInfo);
        assertThat(postInfo).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,1,0", "1,1,1", "1,1,2", "1,0,0", "1,0,1", "1,0,2"})
    @DisplayName("조건에 따른 판매글 정보 확인")
    void findAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag, Integer status) {
        List<PostInfo> allPostInfo = postRepository.findAllPostInfoByProductIdAndRentalFlagAndStatus(
                productId, rentalFlag, status);
        assertThat(allPostInfo).allMatch((postInfo) ->
                postInfo.getRentalFlag() == rentalFlag && postInfo.getStatus() == status);
    }
}