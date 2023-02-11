package com.zeunala.gamerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Deal {
    Integer id;
    Integer postId;
    Integer buyerUsersId;
    Integer totalPrice; // 최종 거래금액
    String createDate; // DB에 INSERT 시각으로 정해지며 생성자에 존재하지 않음
    Integer status; // 예약중 0, 구매자 입금 1, 판매자 인계 2, 렌탈중 3, 구매자 반환 4, 판매자 반환수령 및 보증금 입금 5, 거래종료 6, 초기값은 0으로 생성자에 존재하지 않음

    public Deal(Integer postId, Integer buyerUsersId, Integer totalPrice) {
        this.postId = postId;
        this.buyerUsersId = buyerUsersId;
        this.totalPrice = totalPrice;
    }
}
