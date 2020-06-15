package com.example.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Timestamp regDate;
    private Timestamp updateDate;
    private Boolean isComplete;
}
