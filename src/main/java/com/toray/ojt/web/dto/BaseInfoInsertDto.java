package com.toray.ojt.web.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;


public class BaseInfoInsertDto {
    private Timestamp crtTimestamp;
    private String crtUserId;
    private Timestamp updTimestamp;
    private String updUserId;
    private Long seqInfo;
    private String beginYmd;
    private String endYmd;
    private String importantFlg;
    private String title;
    private String text;
    private Long attachClassNo;

    public Timestamp getCrtTimestamp() {
        return crtTimestamp;
    }

    public void setCrtTimestamp(Timestamp crtTimestamp) {
        this.crtTimestamp = crtTimestamp;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public Long getSeqInfo() {
        return seqInfo;
    }

    public void setSeqInfo(Long seqInfo) {
        this.seqInfo = seqInfo;
    }

    public String getBeginYmd() {
        return beginYmd;
    }

    public void setBeginYmd(String beginYmd) {
        this.beginYmd = beginYmd;
    }

    public String getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(String endYmd) {
        this.endYmd = endYmd;
    }

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

    public Long getAttachClassNo() {
        return attachClassNo;
    }

    public void setAttachClassNo(Long attachClassNo) {
        this.attachClassNo = attachClassNo;
    }
}
