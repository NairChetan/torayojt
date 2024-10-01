package com.toray.ojt.web.entity;


import java.sql.Timestamp;
import java.util.Date;

public class BaseInfo {

    private Timestamp crtTimestamp;
    private String crtUserId;
    private Timestamp updTimestamp;
    private String updUserId;
    private Long seqInfo;
    private Date beginYmd;
    private Date endYmd;
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

    public Long getAttachClassNo() {
        return attachClassNo;
    }

    public void setAttachClassNo(Long attachClassNo) {
        this.attachClassNo = attachClassNo;
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

    public Date getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(Date endYmd) {
        this.endYmd = endYmd;
    }

    public Date getBeginYmd() {
        return beginYmd;
    }

    public void setBeginYmd(Date beginYmd) {
        this.beginYmd = beginYmd;
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

    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    public BaseInfo() {
    }

    public BaseInfo(Timestamp crtTimestamp, String crtUserId, Timestamp updTimestamp, String updUserId, Long seqInfo, Date beginYmd, Date endYmd, String importantFlg, String title, String text, Long attachClassNo) {
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.seqInfo = seqInfo;
        this.beginYmd = beginYmd;
        this.endYmd = endYmd;
        this.importantFlg = importantFlg;
        this.title = title;
        this.text = text;
        this.attachClassNo = attachClassNo;
    }
}
