package com.zeunala.gamerental.controller;

import com.zeunala.gamerental.service.PostService;
import com.zeunala.gamerental.service.UsersService;
import com.zeunala.gamerental.util.PostStatus;
import com.zeunala.gamerental.util.SessionName;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/post")
@Slf4j
public class PostController {
    private final PostService postService;
    private final UsersService usersService;


    @DeleteMapping("/{postId}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> deletePost(@PathVariable Integer postId, HttpSession session) {
        // 존재하지 않는 판매글인 경우 접근 불가
        if (postService.getPostInfoByPostId(postId) == null) {
            return new ResponseEntity<>(Map.of("message", "삭제할 글이 없습니다."), HttpStatus.NOT_FOUND);
        }

        // 판매자가 아닌 경우 접근 불가
        Integer sessionUsersId = (Integer) session.getAttribute(SessionName.LOGIN_USERS_ID);
        String sellerUsersNickname = postService.getPostInfoByPostId(postId).getSellerUsersNickname();
        Integer sellerUsersId = usersService.getUsersByNickname(sellerUsersNickname).getId();
        if (!sessionUsersId.equals(sellerUsersId)) {
            return new ResponseEntity<>(Map.of("message", "판매자만 삭제 가능합니다."), HttpStatus.FORBIDDEN);
        }

        // 거래전 글이 아니면 삭제 불가
        if (!postService.getPostInfoByPostId(postId).getStatus().equals(PostStatus.REGISTERING_POST)) {
            return new ResponseEntity<>(Map.of("message", "거래 대기 물품만 삭제 가능합니다."), HttpStatus.FORBIDDEN);
        }

        // 글 삭제
        if (!postService.deletePostById(postId)) {
            return new ResponseEntity<>(Map.of("message", "삭제할 글이 없습니다."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Map.of("message", "삭제가 완료되었습니다."), HttpStatus.OK);
    }
}
