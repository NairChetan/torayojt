package com.toray.ojt.web.entity;

import java.sql.Timestamp;

public class BaseInfoViewRoleName {

    private String role;
    private String roleName;
    private String description;
    private Timestamp crtTimestamp;
    private Timestamp updTimestamp;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCrtTimestamp() {
        return crtTimestamp;
    }

    public void setCrtTimestamp(Timestamp crtTimestamp) {
        this.crtTimestamp = crtTimestamp;
    }

    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }


    public BaseInfoViewRoleName() {
    }

    public BaseInfoViewRoleName(String role, String roleName, String description, Timestamp crtTimestamp, Timestamp updTimestamp) {
        this.role = role;
        this.roleName = roleName;
        this.description = description;
        this.crtTimestamp = crtTimestamp;
        this.updTimestamp = updTimestamp;
    }
}
