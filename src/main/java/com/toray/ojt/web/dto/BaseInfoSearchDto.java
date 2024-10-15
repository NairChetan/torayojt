package com.toray.ojt.web.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


public class BaseInfoSearchDto {


    private String importantFlg;
    private String title;
    private String text;
    private LocalDate beginYmd;
    private LocalDate endYmd;
    private Timestamp updTimestamp;
    private Long seqInfo;

    public String getImportantFlg() {
        return importantFlg;
    }

    public void setImportantFlg(String importantFlg) {
        this.importantFlg = importantFlg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public LocalDate getBeginYmd() {
        return beginYmd;
    }

    public void setBeginYmd(LocalDate beginYmd) {
        this.beginYmd = beginYmd;
    }

    public LocalDate getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(LocalDate endYmd) {
        this.endYmd = endYmd;
    }

    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public Long getSeqInfo() {
        return seqInfo;
    }

    public void setSeqInfo(Long seqInfo) {
        this.seqInfo = seqInfo;
    }
}
