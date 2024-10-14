package com.toray.ojt.web.dto;

import jakarta.validation.constraints.NotBlank;

public class BaseInfoViewRoleInsertDto {

    private Long seqInfo;

    @NotBlank(message = "Role cannot be null or blank")
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
