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
    String postCreateDate; // "2023-01-01 15:01:02"의 형태로 저장
    String dealCreateDate; // "2023-01-01 15:01:02"의 형태로 저장
    Integer postStatus; // 대기물품 0, 거래중 1, 거래종료 2
    Integer dealStatus; // 입금대기/거래전 0, 구매자입금 1, 렌탈중 2, 종료예정 3, 거래종료 4

    // 대출 기간 getter (deal 테이블에 따로 두지 않음)
    public Integer getRentalPeriod() {
        if (rentalFlag != 1) {
            return null;
        }

        if (this.deposit != null) {
            return (this.totalPrice - this.deposit) / price;
        }
        return this.totalPrice / this.price;
    }

    public DealInfo(Integer id, Integer postId, String buyerUsersNickname, String sellerUsersNickname,
                    String sellerUsersHomeAddress, Integer rentalFlag, Integer directFlag, String categoryName,
                    String title, Integer price, Integer extensionPrice, Integer totalPrice, Integer deposit,
                    String comment, String postCreateDate, String dealCreateDate, Integer postStatus,
                    Integer dealStatus) {
        this.id = id;
        this.postId = postId;
        this.buyerUsersNickname = buyerUsersNickname;
        this.sellerUsersNickname = sellerUsersNickname;
        this.sellerUsersHomeAddress = sellerUsersHomeAddress;
        this.rentalFlag = rentalFlag;
        this.directFlag = directFlag;
        this.categoryName = categoryName;
        this.title = title;
        this.price = price;
        this.extensionPrice = extensionPrice;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.comment = comment;
        this.postCreateDate = postCreateDate;
        this.dealCreateDate = dealCreateDate;
        this.postStatus = postStatus;
        this.dealStatus = dealStatus;
    }

    public DealInfo(Deal deal) {
        this.id = deal.getId();
        this.postId = deal.getPost().getId();
        this.buyerUsersNickname = deal.getBuyerUsers().getNickname();
        this.sellerUsersNickname = deal.getPost().getSellerUsers().getNickname();
        this.sellerUsersHomeAddress = deal.getPost().getSellerUsers().getHomeAddress();
        this.rentalFlag = deal.getPost().getRentalFlag();
        this.directFlag = deal.getPost().getDirectFlag();
        this.categoryName = deal.getPost().getProduct().getCategory().getName();
        this.title = deal.getPost().getProduct().getTitle();
        this.price = deal.getPost().getPrice();
        this.extensionPrice = deal.getPost().getExtensionPrice();
        this.totalPrice = deal.getTotalPrice();
        this.deposit = deal.getPost().getDeposit();
        this.comment = deal.getPost().getComment();
        this.postCreateDate = deal.getPost().getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.dealCreateDate = deal.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.postStatus = deal.getPost().getStatus();
        this.dealStatus = deal.getStatus();
    }
}
