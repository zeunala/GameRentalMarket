package com.zeunala.gamerental.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Users {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String nickname;
    private String email;
    private String tel;
    private String homeAddress;
    private String loginId;
    private String loginPassword;
}
