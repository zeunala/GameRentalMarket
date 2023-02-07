package com.zeunala.gamerental.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class RegisterSellForm {
    @NotNull(message = "판매유형을 선택해주세요.")
    @Range(min = 0, max = 1, message = "정상적이지 않은 선택입니다.")
    Integer rentalFlag; // 렌탈일 경우 1, 중고판매일 경우 0

    @NotNull(message = "거래방법을 선택해주세요.")
    @Range(min = 0, max = 1, message = "정상적이지 않은 선택입니다.")
    Integer directFlag; // 직거래일경우 1, 택배거래일 경우 0

    @NotNull(message = "가격을 입력해주세요.")
    @Positive(message = "올바른 가격을 입력해주세요.")
    Integer price;

    @Positive(message = "올바른 가격을 입력해주세요.")
    Integer extensionPrice; // 3주 초과시 1주당 초과요금

    @Positive(message = "올바른 가격을 입력해주세요.")
    Integer deposit; // 보증금(판매자가 설정가능함)

    @NotBlank(message = "판매문구를 입력해주세요.")
    String comment;

    public RegisterSellForm(Integer rentalFlag, Integer directFlag, Integer price,
                            Integer extensionPrice, Integer deposit, String comment) {
        this.rentalFlag = rentalFlag;
        this.directFlag = directFlag;
        this.price = price;
        this.extensionPrice = extensionPrice;
        this.deposit = deposit;
        this.comment = comment;
    }
}
