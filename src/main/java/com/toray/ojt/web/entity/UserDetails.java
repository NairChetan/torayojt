package com.toray.ojt.web.entity;

import java.sql.Timestamp;

public class UserDetails {
    private String partyId;            // PARTY_ID
    private String partyKind;          // PARTY_KIND
    private String partyNameKj;        // PARTY_NAME_KJ
    private String partyNameKn;        // PARTY_NAME_KN
    private String partyNameEn;        // PARTY_NAME_EN
    private String zipCode;            // ZIP_CODE
    private String address;            // ADDRESS
    private String tel;                // TEL
    private String fax;                // FAX
    private String email;              // EMAIL
    private char state;                // STATE
    private Timestamp updTimestamp;    // UPD_TIMESTAMP
    private String updUserid;          // UPD_USERID
    private String description;         // DESCRIPTION
    private String email2;             // EMAIL2
    private String email3;             // EMAIL3
    private String email4;             // EMAIL4
    private String email5;             // EMAIL5
    private Timestamp crtTimestamp;    // CRT_TIMESTAMP
    private String crtUserid;          // CRT_USERID
    private Integer sortNo;            // SORT_NO

    // Constructors
    public UserDetails() {
    }

    public UserDetails(String partyId, String partyKind, String partyNameKj, String partyNameKn,
                       String partyNameEn, String zipCode, String address, String tel, String fax,
                       String email, char state, Timestamp updTimestamp, String updUserid,
                       String description, String email2, String email3, String email4,
                       String email5, Timestamp crtTimestamp, String crtUserid, Integer sortNo) {
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
        this.updUserid = updUserid;
        this.description = description;
        this.email2 = email2;
        this.email3 = email3;
        this.email4 = email4;
        this.email5 = email5;
        this.crtTimestamp = crtTimestamp;
        this.crtUserid = crtUserid;
        this.sortNo = sortNo;
    }

    // Getters and Setters
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

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
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

    public String getCrtUserid() {
        return crtUserid;
    }

    public void setCrtUserid(String crtUserid) {
        this.crtUserid = crtUserid;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
