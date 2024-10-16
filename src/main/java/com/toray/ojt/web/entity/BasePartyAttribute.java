package com.toray.ojt.web.entity;

import java.sql.Timestamp;

public class BasePartyAttribute {

    private String partyId;
    private String attributeName;
    private Integer attributeSortNo;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private String value5;
    private java.sql.Timestamp updTimestamp;
    private String updUserId;
    private java.sql.Timestamp crtTimestamp;
    private String crtUserId;


    public BasePartyAttribute(String partyId, String attributeName, Integer attributeSortNo, String value1, String value2, String value3, String value4, String value5, Timestamp updTimestamp, String updUserId, Timestamp crtTimestamp, String crtUserId) {
        this.partyId = partyId;
        this.attributeName = attributeName;
        this.attributeSortNo = attributeSortNo;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
    }

    public BasePartyAttribute() {
    }

    // Getters and Setters

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Integer getAttributeSortNo() {
        return attributeSortNo;
    }

    public void setAttributeSortNo(Integer attributeSortNo) {
        this.attributeSortNo = attributeSortNo;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public java.sql.Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(java.sql.Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public java.sql.Timestamp getCrtTimestamp() {
        return crtTimestamp;
    }

    public void setCrtTimestamp(java.sql.Timestamp crtTimestamp) {
        this.crtTimestamp = crtTimestamp;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }


}

