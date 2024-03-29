package com.zeunala.gamerental.dto;

import com.zeunala.gamerental.domain.Deal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DealDto {
    Integer id;
    Integer postId;
    Integer buyerUsersId;
    Integer totalPrice; // 최종 거래금액
    String createDate; // DB에 INSERT 시각으로 정해지며 생성자에 존재하지 않음
    Integer status; // 입금대기/거래전 0, 구매자입금 1, 렌탈중 2, 종료예정 3, 거래종료 4, 초기값은 0으로 생성자에 존재하지 않음

    public DealDto(Integer postId, Integer buyerUsersId, Integer totalPrice) {
        this.postId = postId;
        this.buyerUsersId = buyerUsersId;
        this.totalPrice = totalPrice;
    }

    public DealDto(Deal deal) {
        this.id = deal.getId();
        this.postId = deal.getPost().getId();
        this.buyerUsersId = deal.getBuyerUsers().getId();
        this.totalPrice = deal.getTotalPrice();
        this.createDate = deal.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.status = deal.getStatus();
    }
}
