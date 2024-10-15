package com.toray.ojt.web.entity;

import java.util.Date;

public class TGuide {
    private Date crtTimestamp;
    private String crtUserId;
    private Date updTimestamp;
    private String updUserId;
    private Long seqGuide;  // Primary Key
    private Date beginYmd;
    private Date endYmd;
    private String importantFlg;
    private String title;
    private String text;
    private Long attachClassNo;

    public TGuide(Date crtTimestamp, String crtUserId, Date updTimestamp, String updUserId, Long seqGuide, Date beginYmd, Date endYmd, String importantFlg, String title, String text, Long attachClassNo) {
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.seqGuide = seqGuide;
        this.beginYmd = beginYmd;
        this.endYmd = endYmd;
        this.importantFlg = importantFlg;
        this.title = title;
        this.text = text;
        this.attachClassNo = attachClassNo;
    }

    public TGuide() {
    }

    public Date getCrtTimestamp() {
        return crtTimestamp;
    }

    public void setCrtTimestamp(Date crtTimestamp) {
        this.crtTimestamp = crtTimestamp;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    public Date getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Date updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public Long getSeqGuide() {
        return seqGuide;
    }

    public void setSeqGuide(Long seqGuide) {
        this.seqGuide = seqGuide;
    }

    public Date getBeginYmd() {
        return beginYmd;
    }

    public void setBeginYmd(Date beginYmd) {
        this.beginYmd = beginYmd;
    }

    public Date getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(Date endYmd) {
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
