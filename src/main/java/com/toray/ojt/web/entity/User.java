package com.toray.ojt.web.entity;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private  String partyId;
    private String accountId;
    private String accountPassword;
    private String state;
    private Date expDate;
    private Integer failedLoginCount;
    private Timestamp updTimestamp;
    private String updUserid;
    private Integer failedLoginAttempts;
    private String accountKind;
    private Date lastLoginDate;
    private Timestamp crtTimestamp;
    private String crtUserid;
    private Timestamp dataUpdTimestamp;
    private String dataUpdUserid;
    private String emailLoginState;

    public User(String partyId, String accountId, String accountPassword, String state, Date expDate, Integer failedLoginCount, Timestamp updTimestamp, String updUserid, Integer failedLoginAttempts, String accountKind, Date lastLoginDate, Timestamp crtTimestamp, String crtUserid, Timestamp dataUpdTimestamp, String dataUpdUserid, String emailLoginState) {
        this.partyId = partyId;
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.state = state;
        this.expDate = expDate;
        this.failedLoginCount = failedLoginCount;
        this.updTimestamp = updTimestamp;
        this.updUserid = updUserid;
        this.failedLoginAttempts = failedLoginAttempts;
        this.accountKind = accountKind;
        this.lastLoginDate = lastLoginDate;
        this.crtTimestamp = crtTimestamp;
        this.crtUserid = crtUserid;
        this.dataUpdTimestamp = dataUpdTimestamp;
        this.dataUpdUserid = dataUpdUserid;
        this.emailLoginState = emailLoginState;
    }

    public User() {
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Integer getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(Integer failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public String getUpdUserid() {
        return updUserid;
    }

    public void setUpdUserid(String updUserid) {
        this.updUserid = updUserid;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public String getAccountKind() {
        return accountKind;
    }

    public void setAccountKind(String accountKind) {
        this.accountKind = accountKind;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Timestamp getCrtTimestamp() {
        return crtTimestamp;
    }

    public void setCrtTimestamp(Timestamp crtTimestamp) {
        this.crtTimestamp = crtTimestamp;
    }

    public String getCrtUserid() {
        return crtUserid;
    }

    public void setCrtUserid(String crtUserid) {
        this.crtUserid = crtUserid;
    }

    public Timestamp getDataUpdTimestamp() {
        return dataUpdTimestamp;
    }

    public void setDataUpdTimestamp(Timestamp dataUpdTimestamp) {
        this.dataUpdTimestamp = dataUpdTimestamp;
    }

    public String getDataUpdUserid() {
        return dataUpdUserid;
    }

    public void setDataUpdUserid(String dataUpdUserid) {
        this.dataUpdUserid = dataUpdUserid;
    }

    public String getEmailLoginState() {
        return emailLoginState;
    }

    public void setEmailLoginState(String emailLoginState) {
        this.emailLoginState = emailLoginState;
    }
}
