package com.zeunala.gamerental.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    @NotEmpty
    private String loginId;

    @NotEmpty
    private String loginPassword;

    public LoginForm(String loginId, String loginPassword) {
        this.loginId = loginId;
        this.loginPassword = loginPassword;
    }
}
