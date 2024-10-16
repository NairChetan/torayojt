package com.toray.ojt.web.entity;

import java.sql.Timestamp;

public class BaseParty {
    private String partyId;
    private String partyKind;
    private String partyNameKj;
    private String partyNameKn;
    private String partyNameEn;
    private String zipCode;
    private String address;
    private String tel;
    private String fax;
    private String email;
    private String state;
    private Timestamp updTimestamp;
    private String updUserId;
    private String description;
    private String email2;
    private String email3;
    private String email4;
    private String email5;
    private Timestamp crtTimestamp;
    private String crtUserId;
    private Integer sortNo;

    public BaseParty(String partyId, String partyKind, String partyNameKj, String partyNameKn, String partyNameEn, String zipCode, String address, String tel, String fax, String email, String state, Timestamp updTimestamp, String updUserId, String description, String email2, String email3, String email4, String email5, Timestamp crtTimestamp, String crtUserId, Integer sortNo) {
        this.partyId = partyId;
        this.partyKind = partyKind;
        this.partyNameKj = partyNameKj;
        this.partyNameKn = partyNameKn;
        this.partyNameEn = partyNameEn;
        this.zipCode = zipCode;
        this.address = address;
        this.tel = tel;
        this.fax = fax;
        this.email = email;
        this.state = state;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.description = description;
        this.email2 = email2;
        this.email3 = email3;
        this.email4 = email4;
        this.email5 = email5;
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
        this.sortNo = sortNo;
    }

    public BaseParty() {
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyKind() {
        return partyKind;
    }

    public void setPartyKind(String partyKind) {
        this.partyKind = partyKind;
    }

    public String getPartyNameKj() {
        return partyNameKj;
    }

    public void setPartyNameKj(String partyNameKj) {
        this.partyNameKj = partyNameKj;
    }

    public String getPartyNameKn() {
        return partyNameKn;
    }

    public void setPartyNameKn(String partyNameKn) {
        this.partyNameKn = partyNameKn;
    }

    public String getPartyNameEn() {
        return partyNameEn;
    }

    public void setPartyNameEn(String partyNameEn) {
        this.partyNameEn = partyNameEn;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getEmail4() {
        return email4;
    }

    public void setEmail4(String email4) {
        this.email4 = email4;
    }

    public String getEmail5() {
        return email5;
    }

    public void setEmail5(String email5) {
        this.email5 = email5;
    }

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

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
