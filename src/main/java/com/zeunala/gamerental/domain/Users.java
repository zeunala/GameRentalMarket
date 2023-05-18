package com.zeunala.gamerental.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Users(Integer id, String name, String nickname, String email, String tel, String homeAddress,
                 String loginId, String loginPassword) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.tel = tel;
        this.homeAddress = homeAddress;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
    }
}
