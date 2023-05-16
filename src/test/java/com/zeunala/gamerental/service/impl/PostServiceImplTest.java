package com.zeunala.gamerental.service.impl;

import com.zeunala.gamerental.dto.PostDto;
import com.zeunala.gamerental.dto.PostInfo;
import com.zeunala.gamerental.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Slf4j
@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("1개의 판매글 정보 확인")
    void getPostInfoByPostId(Integer postId) {
        PostInfo postInfo = postService.getPostInfoByPostId(postId);
        log.info("{}번 판매글 정보: {}", postId, postInfo);
        assertThat(postInfo).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {11111111, 22222222, 33333333, 44444444, -1})
    @DisplayName("존재하지 않는 판매글 정보 확인시 null 리턴")
    void getPostInfoByPostId_NotExist_ReturnNull(Integer postId) {
        assertThat(postService.getPostInfoByPostId(postId)).isNull();
    }

    @ParameterizedTest
    @CsvSource({"1,1,0", "1,1,1", "1,1,2", "1,0,0", "1,0,1", "1,0,2"})
    @DisplayName("조건에 따른 판매글 정보 확인")
    void getAllPostInfoByProductIdAndRentalFlagAndStatus(Integer productId, Integer rentalFlag, Integer status) {
        List<PostInfo> allPostInfo = postService.getAllPostInfoByProductIdAndRentalFlagAndStatus(
                productId, rentalFlag, status);
        assertThat(allPostInfo).allMatch((postInfo) ->
                postInfo.getRentalFlag() == rentalFlag && postInfo.getStatus() == status);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("판매자 id에 따른 판매글 정보 확인")
    void getAllPostInfoBySellerUsersId(Integer sellerUsersId) {
        List<PostInfo> allPostInfo = postService.getAllPostInfoBySellerUsersId(sellerUsersId);
        log.info("판매자 id {}의 판매글 정보들: {}", sellerUsersId, allPostInfo);
        assertThat(allPostInfo).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,0", "1,2"})
    @DisplayName("판매자 id/status 조건에 따른 판매글 정보 확인")
    void getAllPostInfoBySellerUsersIdAndStatus(Integer sellerUsersId, Integer status) {
        List<PostInfo> allPostInfo = postService.getAllPostInfoBySellerUsersIdAndStatus(
                sellerUsersId, status);
        assertThat(allPostInfo).allMatch((postInfo) -> postInfo.getStatus() == status);
    }

    @Test
    @DisplayName("새로운 판매글 추가")
    void registerPost() {
        PostDto postDto = new PostDto(1, 1, 1, 1, 5000, 1000, null, "물건 싸게 빌려드립니다~");
        PostDto savedPostDto = postService.registerPost(postDto);
        log.info("추가된 판매글: {}", savedPostDto);
        assertThat(savedPostDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("새로운 판매글을 추가하고 정보가 정상적으로 조회되는지 테스트")
    void registerPost_RegisterThenFind_IsNotNull() {
        PostDto postDto = new PostDto(1, 1, 0, 1, 25000, null, null, "물건 싸게 팝니다~");
        PostDto savedPostDto = postService.registerPost(postDto);
        PostInfo findPostInfo = postService.getPostInfoByPostId(savedPostDto.getId());
        log.info("조회된 판매글 정보: {}", findPostInfo);
        assertThat(findPostInfo).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,1,true", "2,2,true", "3,2,true", "99999,2,false"})
    @DisplayName("status 값을 바꾸고 변경값 확인")
    void changeStatusById(Integer id, Integer status, Boolean expected) {
        Boolean updateResult = postService.changeStatusById(id, status);
        assertThat(updateResult).isEqualTo(expected);
        if (updateResult) {
            assertThat(postService.getPostInfoByPostId(id).getStatus()).isEqualTo(status);
        }
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "100,false", "-1,false"})
    @DisplayName("판매글 삭제시 삭제유무를 리턴하고 정보가 조회되지 않는지 테스트")
    void deletePostById(Integer id, Boolean expected) {
        assertThat(postService.deletePostById(id)).isEqualTo(expected);
        assertThat(postService.getPostInfoByPostId(id)).isNull();
    }
}