package com.zeunala.gamerental.dto;

import com.zeunala.gamerental.domain.Promotion;
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

    public PromotionInfo(Promotion promotion) {
        this.id = promotion.getId();
        this.filePath = promotion.getFile().getPath();
        this.url = promotion.getUrl();
    }
}
