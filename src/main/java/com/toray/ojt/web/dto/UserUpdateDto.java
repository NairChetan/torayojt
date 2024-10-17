package com.toray.ojt.web.dto;


public class UserUpdateDto {
    private String accountId;
    private String state;
    private Integer failedLoginAttempts;

    public UserUpdateDto(String accountId,String state, Integer failedLoginAttempts) {
        this.accountId = accountId;
        this.state = state;
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public UserUpdateDto() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }
}