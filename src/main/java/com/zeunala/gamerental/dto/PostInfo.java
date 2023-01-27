package com.zeunala.gamerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostInfo {
    Integer id;
    String sellerUsersNickname;
    String sellerUsersHomeAddress;
    Integer rentalFlag; // 렌탈일 경우 1, 직거래일 경우 0
    Integer directFlag; // 직거래일경우 1, 택배거래일 경우 0
    String categoryName;
    String title;
    Integer price;
    Integer extensionPrice; // 3주 초과시 1주당 초과요금
    Integer deposit; // 보증금(판매자가 설정가능함)
    String comment;
    String createDate;
    Integer status; // 대기물품 0, 거래중 1, 거래종료 2

    public PostInfo(Integer id, String sellerUsersNickname, Integer rentalFlag, Integer directFlag,
                    String categoryName, String title, Integer price, Integer extensionPrice, Integer deposit,
                    String comment, String createDate, Integer status) {
        this.id = id;
        this.sellerUsersNickname = sellerUsersNickname;
        this.rentalFlag = rentalFlag;
        this.directFlag = directFlag;
        this.categoryName = categoryName;
        this.title = title;
        this.price = price;
        this.extensionPrice = extensionPrice;
        this.deposit = deposit;
        this.comment = comment;
        this.createDate = createDate;
        this.status = status;
    }
}
