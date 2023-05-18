package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
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
}
