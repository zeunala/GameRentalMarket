package com.zeunala.gamerental.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class File {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String path;
    private LocalDate createDate;
    private LocalDate modifyDate;
}
