package com.zeunala.gamerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductInfo {
    Integer id;
    String title;
    String description;
    Integer originalPrice;
    String filePath;
    String createDate; // "2023-01-01 15:01:02"의 형태로 저장
    Integer minRentalPrice;
    Integer minUsedPrice;

    public ProductInfo(Integer id, String title, String description, Integer originalPrice, String filePath,
                       String createDate, Integer minRentalPrice, Integer minUsedPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.originalPrice = originalPrice;
        this.filePath = filePath;
        this.createDate = createDate;
        this.minRentalPrice = minRentalPrice;
        this.minUsedPrice = minUsedPrice;
    }
}
