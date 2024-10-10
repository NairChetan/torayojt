package com.toray.ojt.web.dto;

import com.toray.ojt.web.entity.BaseInfoViewRole;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class BaseInfoDetailsBasedOnSeqInfoDto {
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
    private List<BaseInfoViewRole> roles;

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

    public Long getAttachClassNo() {
        return attachClassNo;
    }

    public void setAttachClassNo(Long attachClassNo) {
        this.attachClassNo = attachClassNo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<BaseInfoViewRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseInfoViewRole> roles) {
        this.roles = roles;
    }
}
