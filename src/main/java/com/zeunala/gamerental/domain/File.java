package com.zeunala.gamerental.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String path;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public File(Integer id, String name, String path, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
