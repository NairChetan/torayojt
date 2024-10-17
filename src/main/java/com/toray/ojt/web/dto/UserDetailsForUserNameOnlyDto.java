package com.toray.ojt.web.dto;

public class UserDetailsForUserNameOnlyDto {
    private String partyId;
    private String partyNameKj;        // PARTY_NAME_KJ
    private String partyNameKn;        // PARTY_NAME_KN
    private String partyNameEn;        // PARTY_NAME_EN

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
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


}
