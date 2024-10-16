package com.toray.ojt.web.entity;

import java.util.Date;

public class TKaitoUser {
    private Date crtTimestamp;
    private String crtUserId;
    private Date updTimestamp;
    private String updUserId;
    private Long seqKaitoUser;
    private Long seqKaito;
    private String userKbn;
    private String userId;
    private String org;
    private String kaisha;
    private String busho;
    private String yakushoku;
    private String email;

    public TKaitoUser() {
    }

    public TKaitoUser(Date crtTimestamp, String crtUserId, Date updTimestamp, String updUserId, Long seqKaitoUser, Long seqKaito, String userKbn, String userId, String org, String kaisha, String busho, String yakushoku, String email) {
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.seqKaitoUser = seqKaitoUser;
        this.seqKaito = seqKaito;
        this.userKbn = userKbn;
        this.userId = userId;
        this.org = org;
        this.kaisha = kaisha;
        this.busho = busho;
        this.yakushoku = yakushoku;
        this.email = email;
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

    public Long getSeqKaitoUser() {
        return seqKaitoUser;
    }

    public void setSeqKaitoUser(Long seqKaitoUser) {
        this.seqKaitoUser = seqKaitoUser;
    }

    public Long getSeqKaito() {
        return seqKaito;
    }

    public void setSeqKaito(Long seqKaito) {
        this.seqKaito = seqKaito;
    }

    public String getUserKbn() {
        return userKbn;
    }

    public void setUserKbn(String userKbn) {
        this.userKbn = userKbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getKaisha() {
        return kaisha;
    }

    public void setKaisha(String kaisha) {
        this.kaisha = kaisha;
    }

    public String getBusho() {
        return busho;
    }

    public void setBusho(String busho) {
        this.busho = busho;
    }

    public String getYakushoku() {
        return yakushoku;
    }

    public void setYakushoku(String yakushoku) {
        this.yakushoku = yakushoku;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
