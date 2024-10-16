package com.toray.ojt.web.entity;

import java.util.Date;

public class BaseCode {

    private String codeKind;
    private String code;
    private String locale;
    private String codeValue1;
    private String codeValue2;
    private String codeValue3;
    private String codeValue4;
    private String codeValue5;
    private String codeValue6;
    private String codeValue7;
    private String codeValue8;
    private String codeValue9;
    private String codeValue10;
    private Integer sortNo;
    private Date updTimestamp;
    private String updUserId;
    private Date crtTimestamp;
    private String crtUserId;

    public BaseCode() {
    }

    public BaseCode(String codeKind, String code, String locale, String codeValue1, String codeValue2, String codeValue3, String codeValue4, String codeValue5, String codeValue6, String codeValue7, String codeValue8, String codeValue9, String codeValue10, Integer sortNo, Date updTimestamp, String updUserId, Date crtTimestamp, String crtUserId) {
        this.codeKind = codeKind;
        this.code = code;
        this.locale = locale;
        this.codeValue1 = codeValue1;
        this.codeValue2 = codeValue2;
        this.codeValue3 = codeValue3;
        this.codeValue4 = codeValue4;
        this.codeValue5 = codeValue5;
        this.codeValue6 = codeValue6;
        this.codeValue7 = codeValue7;
        this.codeValue8 = codeValue8;
        this.codeValue9 = codeValue9;
        this.codeValue10 = codeValue10;
        this.sortNo = sortNo;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
    }

    public String getCodeKind() {
        return codeKind;
    }

    public void setCodeKind(String codeKind) {
        this.codeKind = codeKind;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCodeValue1() {
        return codeValue1;
    }

    public void setCodeValue1(String codeValue1) {
        this.codeValue1 = codeValue1;
    }

    public String getCodeValue2() {
        return codeValue2;
    }

    public void setCodeValue2(String codeValue2) {
        this.codeValue2 = codeValue2;
    }

    public String getCodeValue3() {
        return codeValue3;
    }

    public void setCodeValue3(String codeValue3) {
        this.codeValue3 = codeValue3;
    }

    public String getCodeValue4() {
        return codeValue4;
    }

    public void setCodeValue4(String codeValue4) {
        this.codeValue4 = codeValue4;
    }

    public String getCodeValue5() {
        return codeValue5;
    }

    public void setCodeValue5(String codeValue5) {
        this.codeValue5 = codeValue5;
    }

    public String getCodeValue6() {
        return codeValue6;
    }

    public void setCodeValue6(String codeValue6) {
        this.codeValue6 = codeValue6;
    }

    public String getCodeValue7() {
        return codeValue7;
    }

    public void setCodeValue7(String codeValue7) {
        this.codeValue7 = codeValue7;
    }

    public String getCodeValue8() {
        return codeValue8;
    }

    public void setCodeValue8(String codeValue8) {
        this.codeValue8 = codeValue8;
    }

    public String getCodeValue9() {
        return codeValue9;
    }

    public void setCodeValue9(String codeValue9) {
        this.codeValue9 = codeValue9;
    }

    public String getCodeValue10() {
        return codeValue10;
    }

    public void setCodeValue10(String codeValue10) {
        this.codeValue10 = codeValue10;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
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
}
