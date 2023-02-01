package com.zeunala.gamerental.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinForm {
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(max = 20, message = "아이디가 너무 깁니다.")
    String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(max = 100, message = "비밀번호가 너무 깁니다.")
    String loginPassword;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 20, message = "올바른 이름을 입력해주세요.")
    String name;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(max = 20, message = "닉네임이 너무 깁니다.")
    String nickname;

    @NotBlank(message = "주소를 선택해주세요.")
    String homeAddressSido;

    @NotBlank(message = "주소를 선택해주세요.")
    String homeAddressSigugun;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    String email;

    @NotBlank(message = "휴대전화번호를 입력해주세요.")
    @Pattern(regexp = "^01\\d-\\d{4}-\\d{4}$", message = "010-1234-5678과 같은 형식으로 입력해주세요.")
    String tel;

    public JoinForm(String loginId, String loginPassword, String name, String nickname, String homeAddressSido,
                    String homeAddressSigugun, String email, String tel) {
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
        this.nickname = nickname;
        this.homeAddressSido = homeAddressSido;
        this.homeAddressSigugun = homeAddressSigugun;
        this.email = email;
        this.tel = tel;
    }
}
