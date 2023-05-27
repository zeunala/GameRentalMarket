package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="file_id")
    private File file;

    private String url;

    public Promotion(Integer id, File file, String url) {
        this.id = id;
        this.file = file;
        this.url = url;
    }
}
