package com.zeunala.gamerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
    Integer id; // DB에서 생성할 PK값으로 생성자에 존재하지 않음
    Integer productId;
    Integer sellerUsersId;
    Integer rentalFlag; // 렌탈일 경우 1, 중고판매일 경우 0
    Integer directFlag; // 직거래일경우 1, 택배거래일 경우 0
    Integer price;
    Integer extensionPrice; // 3주 초과시 1주당 초과요금
    Integer deposit; // 보증금(판매자가 설정가능함)
    String comment;
    String createDate; // DB에 INSERT 시각으로 정해지며 생성자에 존재하지 않음
    Integer status; // 대기물품 0, 거래중 1, 거래종료 2, 초기값은 0으로 생성자에 존재하지 않음

    public Post(Integer productId, Integer sellerUsersId, Integer rentalFlag, Integer directFlag,
                Integer price, Integer extensionPrice, Integer deposit, String comment) {
        this.productId = productId;
        this.sellerUsersId = sellerUsersId;
        this.rentalFlag = rentalFlag;
        this.directFlag = directFlag;
        this.price = price;
        this.extensionPrice = extensionPrice;
        this.deposit = deposit;
        this.comment = comment;
    }
}
