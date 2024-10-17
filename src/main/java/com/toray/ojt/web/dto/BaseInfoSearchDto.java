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
    private String updUserId;
    private String partyNameEn = "Test User";
    private String partyNameKj = "テストユーザー";
    private String partyNameKn = "テストユーザー";

    public String getPartyNameEn() {
        return partyNameEn;
    }

    public void setPartyNameEn(String partyNameEn) {
        this.partyNameEn = partyNameEn;
    }

    public String getPartyNameKj() {
        return partyNameKj;
    }

    public void setPartyNameKj(String partyNameKj) {
        this.partyNameKj = partyNameKj;
    }

    public String getPartyNameKn() {
        return partyNameKn;
    }

    public void setPartyNameKn(String partyNameKn) {
        this.partyNameKn = partyNameKn;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
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
