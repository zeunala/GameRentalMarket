package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String title;
    private String description;
    private Integer originalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File file;

    private LocalDateTime createDate;

    public Product(Integer id, Category category, String title, String description, Integer originalPrice,
                   File file, LocalDateTime createDate) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.originalPrice = originalPrice;
        this.file = file;
        this.createDate = createDate;
    }
}
