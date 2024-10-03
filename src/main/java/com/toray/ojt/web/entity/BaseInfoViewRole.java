package com.toray.ojt.web.entity;

public class BaseInfoViewRole {

    private Long seqInfo;
    private String role;

    public Long getSeqInfo() {
        return seqInfo;
    }

    public void setSeqInfo(Long seqInfo) {
        this.seqInfo = seqInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BaseInfoViewRole() {
    }

    public BaseInfoViewRole(Long seqInfo, String role) {
        this.seqInfo = seqInfo;
        this.role = role;
    }
}
