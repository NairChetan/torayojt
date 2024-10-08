package com.toray.ojt.web.dto;

public class BaseInfoViewRoleInsertDto {

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
}
