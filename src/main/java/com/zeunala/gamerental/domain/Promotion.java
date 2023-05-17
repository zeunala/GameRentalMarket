package com.zeunala.gamerental.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Promotion {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="file_id")
    private File file;

    private String url;
}
