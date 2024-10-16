package com.toray.ojt.web.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class NoticeSearchResultDto {

    private String importantFlg;
    private String title;
    private String text;
    private LocalDate beginYmd;
    private LocalDate endYmd;
    private Timestamp updTimestamp;
    private Long seqInfo;
    private String updUserId;
    private String partyId;
    private String partyNameKj;        // PARTY_NAME_KJ
    private String partyNameKn;        // PARTY_NAME_KN
    private String partyNameEn;        // PARTY_NAME_EN

    public NoticeSearchResultDto() {
    }

    public NoticeSearchResultDto(String importantFlg, String title, String text, LocalDate beginYmd, LocalDate endYmd, Timestamp updTimestamp, Long seqInfo, String updUserId, String partyId, String partyNameKj, String partyNameKn, String partyNameEn) {
        this.importantFlg = importantFlg;
        this.title = title;
        this.text = text;
        this.beginYmd = beginYmd;
        this.endYmd = endYmd;
        this.updTimestamp = updTimestamp;
        this.seqInfo = seqInfo;
        this.updUserId = updUserId;
        this.partyId = partyId;
        this.partyNameKj = partyNameKj;
        this.partyNameKn = partyNameKn;
        this.partyNameEn = partyNameEn;
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

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
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

    public String getPartyNameEn() {
        return partyNameEn;
    }

    public void setPartyNameEn(String partyNameEn) {
        this.partyNameEn = partyNameEn;
    }

}
