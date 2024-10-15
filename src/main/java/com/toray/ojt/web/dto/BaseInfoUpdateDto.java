package com.toray.ojt.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.sql.Timestamp;

public class BaseInfoUpdateDto {

    private Timestamp updTimestamp;
    private String updUserId;
    private Long seqInfo;
    @NotBlank(message = "Begin date cannot be null or blank")
    private String beginYmd;
    private String endYmd;
    private String importantFlg;
    @NotBlank(message = "Title cannot be null or blank")
    private String title;
    @Size(max = 4000, message = "Text content cannot exceed 4000 bytes")
    private String text;
    private Long attachClassNo;

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
