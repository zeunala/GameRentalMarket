package com.zeunala.gamerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DealInfo {
    Integer id;
    Integer postId;
    String buyerUsersNickname;
    String sellerUsersNickname;
    String sellerUsersHomeAddress;
    Integer rentalFlag; // 렌탈일 경우 1, 중고판매일 경우 0
    Integer directFlag; // 직거래일경우 1, 택배거래일 경우 0
    String categoryName;
    String title;
    Integer price;
    Integer extensionPrice; // 3주 초과시 1주당 초과요금
    Integer totalPrice;
    Integer deposit; // 보증금(판매자가 설정가능함)
    String comment;
    String postCreateDate; // "2023-01-01"의 형태로 저장
    String dealCreateDate; // "2023-01-01"의 형태로 저장
    Integer postStatus; // 대기물품 0, 거래중 1, 거래종료 2
    Integer dealStatus; // 예약중 0, 판매자 인계완료 1, 구매자 인수완료 2, 렌탈중 3, 구매자 반환완료 4, 판매자 반환수령 5, 거래종료 6'
}
