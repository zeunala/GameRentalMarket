package com.zeunala.gamerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {
    Integer id; // DB에서 생성할 PK값으로 생성자에 존재하지 않음
    String name;
    String nickname;
    String email;
    String tel;
    String homeAddress;
    String loginId;
    String loginPassword;

    public UsersDto(String name, String nickname, String email, String tel,
                    String homeAddress, String loginId, String loginPassword) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.tel = tel;
        this.homeAddress = homeAddress;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name.substring(0, name.length() / 2) + "**" + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email.substring(0, email.length() / 2) + "*******" + '\'' +
                ", tel='" + tel.substring(0, tel.length() / 2) + "*******" + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", loginId='" + loginId + '\'' +
                '}';
    }
}
