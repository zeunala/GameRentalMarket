package com.zeunala.gamerental.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PromotionInfo {
    Integer id;
    String filePath;
    String url;

    public PromotionInfo(Integer id, String filePath, String url) {
        this.id = id;
        this.filePath = filePath;
        this.url = url;
    }
}
