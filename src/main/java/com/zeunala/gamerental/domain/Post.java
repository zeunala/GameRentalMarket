package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_users_id")
    private Users sellerUsers;

    private Integer rentalFlag;
    private Integer directFlag;
    private Integer price;
    private Integer extensionPrice;
    private Integer deposit;
    private String comment;
    private LocalDateTime createDate;
    private Integer status;

    public Post(Integer id, Product product, Users sellerUsers, Integer rentalFlag, Integer directFlag,
                Integer price, Integer extensionPrice, Integer deposit, String comment,
                LocalDateTime createDate, Integer status) {
        this.id = id;
        this.product = product;
        this.sellerUsers = sellerUsers;
        this.rentalFlag = rentalFlag;
        this.directFlag = directFlag;
        this.price = price;
        this.extensionPrice = extensionPrice;
        this.deposit = deposit;
        this.comment = comment;
        this.createDate = createDate;
        this.status = status;
    }
}
