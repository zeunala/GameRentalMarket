package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
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
}
