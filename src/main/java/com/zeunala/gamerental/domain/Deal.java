package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Deal {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_users_id")
    private Users buyerUsers;

    private Integer totalPrice;
    private LocalDateTime createDate;
    private Integer status;
    private LocalDateTime expirationDate;

    public Deal(Integer id, Post post, Users buyerUsers, Integer totalPrice,
                LocalDateTime createDate, Integer status, LocalDateTime expirationDate) {
        this.id = id;
        this.post = post;
        this.buyerUsers = buyerUsers;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.status = status;
        this.expirationDate = expirationDate;
    }
}
