package com.toray.ojt.web.dto;

public class ToDoDTO {
    private String gyomuCd;
    private String shushuTxt;
    private String shimekiriYmd;
    private String iraiStatus;
    private Long seqIrai;
    private String kaitoStatus;
    private String userKbn;
    private String userId;
    private String partyNameEn;
    private String locale;
    private String codeValue1;
    private Long requestTotal;

    public ToDoDTO() {
    }

    public ToDoDTO(String gyomuCd, String shushuTxt, String shimekiriYmd, String iraiStatus, Long seqIrai, String kaitoStatus, String userKbn, String userId, String partyNameEn, String locale, String codeValue1 , Long requestTotal) {
        this.gyomuCd = gyomuCd;
        this.shushuTxt = shushuTxt;
        this.shimekiriYmd = shimekiriYmd;
        this.iraiStatus = iraiStatus;
        this.seqIrai = seqIrai;
        this.kaitoStatus = kaitoStatus;
        this.userKbn = userKbn;
        this.userId = userId;
        this.partyNameEn = partyNameEn;
        this.locale = locale;
        this.codeValue1 = codeValue1;
        this.requestTotal = requestTotal;

    }

    public String getGyomuCd() {
        return gyomuCd;
    }

    public void setGyomuCd(String gyomuCd) {
        this.gyomuCd = gyomuCd;
    }

    public String getShushuTxt() {
        return shushuTxt;
    }

    public void setShushuTxt(String shushuTxt) {
        this.shushuTxt = shushuTxt;
    }

    public String getShimekiriYmd() {
        return shimekiriYmd;
    }

    public void setShimekiriYmd(String shimekiriYmd) {
        this.shimekiriYmd = shimekiriYmd;
    }

    public String getIraiStatus() {
        return iraiStatus;
    }

    public void setIraiStatus(String iraiStatus) {
        this.iraiStatus = iraiStatus;
    }

    public Long getSeqIrai() {
        return seqIrai;
    }

    public void setSeqIrai(Long seqIrai) {
        this.seqIrai = seqIrai;
    }

    public String getKaitoStatus() {
        return kaitoStatus;
    }

    public void setKaitoStatus(String kaitoStatus) {
        this.kaitoStatus = kaitoStatus;
    }

    public String getUserKbn() {
        return userKbn;
    }

    public void setUserKbn(String userKbn) {
        this.userKbn = userKbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPartyNameEn() {
        return partyNameEn;
    }

    public void setPartyNameEn(String partyNameEn) {
        this.partyNameEn = partyNameEn;
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

    public Long getRequestTotal() {
        return requestTotal;
    }

    public void setRequestTotal(Long requestTotal) {
        this.requestTotal = requestTotal;
    }
}
