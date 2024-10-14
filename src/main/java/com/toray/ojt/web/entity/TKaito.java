package com.toray.ojt.web.entity;

import java.util.Date;

public class TKaito {

    private Date crtTimestamp;
    private String crtUserId;
    private Date updTimestamp;
    private String updUserId;
    private Long seqKaito;
    private Long seqIrai;
    private String groupCd;
    private String groupTxt;
    private String kaitoStatus;
    private Long formatSeqNo1;
    private Long formatSeqNo2;
    private Long formatSeqNo3;
    private Long formatSeqNo4;
    private Long formatSeqNo5;
    private Long kaitoSeqNo1;
    private Long kaitoSeqNo2;
    private Long kaitoSeqNo3;
    private Long kaitoSeqNo4;
    private Long kaitoSeqNo5;
    private Long refIraiSeqNo1;
    private Long refIraiSeqNo2;
    private Long refIraiSeqNo3;
    private Long refIraiSeqNo4;
    private Long refIraiSeqNo5;
    private Long refKaitoSeqNo1;
    private Long refKaitoSeqNo2;
    private Long refKaitoSeqNo3;
    private Long refKaitoSeqNo4;
    private Long refKaitoSeqNo5;
    private Integer orderNo;

    public TKaito() {
    }

    public TKaito(Date crtTimestamp, String crtUserId, Date updTimestamp, String updUserId, Long seqKaito, Long seqIrai, String groupCd, String groupTxt, String kaitoStatus, Long formatSeqNo1, Long formatSeqNo2, Long formatSeqNo3, Long formatSeqNo4, Long formatSeqNo5, Long kaitoSeqNo1, Long kaitoSeqNo2, Long kaitoSeqNo3, Long kaitoSeqNo4, Long kaitoSeqNo5, Long refIraiSeqNo1, Long refIraiSeqNo2, Long refIraiSeqNo3, Long refIraiSeqNo4, Long refIraiSeqNo5, Long refKaitoSeqNo1, Long refKaitoSeqNo2, Long refKaitoSeqNo3, Long refKaitoSeqNo4, Long refKaitoSeqNo5, Integer orderNo) {
        this.crtTimestamp = crtTimestamp;
        this.crtUserId = crtUserId;
        this.updTimestamp = updTimestamp;
        this.updUserId = updUserId;
        this.seqKaito = seqKaito;
        this.seqIrai = seqIrai;
        this.groupCd = groupCd;
        this.groupTxt = groupTxt;
        this.kaitoStatus = kaitoStatus;
        this.formatSeqNo1 = formatSeqNo1;
        this.formatSeqNo2 = formatSeqNo2;
        this.formatSeqNo3 = formatSeqNo3;
        this.formatSeqNo4 = formatSeqNo4;
        this.formatSeqNo5 = formatSeqNo5;
        this.kaitoSeqNo1 = kaitoSeqNo1;
        this.kaitoSeqNo2 = kaitoSeqNo2;
        this.kaitoSeqNo3 = kaitoSeqNo3;
        this.kaitoSeqNo4 = kaitoSeqNo4;
        this.kaitoSeqNo5 = kaitoSeqNo5;
        this.refIraiSeqNo1 = refIraiSeqNo1;
        this.refIraiSeqNo2 = refIraiSeqNo2;
        this.refIraiSeqNo3 = refIraiSeqNo3;
        this.refIraiSeqNo4 = refIraiSeqNo4;
        this.refIraiSeqNo5 = refIraiSeqNo5;
        this.refKaitoSeqNo1 = refKaitoSeqNo1;
        this.refKaitoSeqNo2 = refKaitoSeqNo2;
        this.refKaitoSeqNo3 = refKaitoSeqNo3;
        this.refKaitoSeqNo4 = refKaitoSeqNo4;
        this.refKaitoSeqNo5 = refKaitoSeqNo5;
        this.orderNo = orderNo;
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

    public Long getSeqKaito() {
        return seqKaito;
    }

    public void setSeqKaito(Long seqKaito) {
        this.seqKaito = seqKaito;
    }

    public Long getSeqIrai() {
        return seqIrai;
    }

    public void setSeqIrai(Long seqIrai) {
        this.seqIrai = seqIrai;
    }

    public String getGroupCd() {
        return groupCd;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public String getGroupTxt() {
        return groupTxt;
    }

    public void setGroupTxt(String groupTxt) {
        this.groupTxt = groupTxt;
    }

    public String getKaitoStatus() {
        return kaitoStatus;
    }

    public void setKaitoStatus(String kaitoStatus) {
        this.kaitoStatus = kaitoStatus;
    }

    public Long getFormatSeqNo1() {
        return formatSeqNo1;
    }

    public void setFormatSeqNo1(Long formatSeqNo1) {
        this.formatSeqNo1 = formatSeqNo1;
    }

    public Long getFormatSeqNo2() {
        return formatSeqNo2;
    }

    public void setFormatSeqNo2(Long formatSeqNo2) {
        this.formatSeqNo2 = formatSeqNo2;
    }

    public Long getFormatSeqNo3() {
        return formatSeqNo3;
    }

    public void setFormatSeqNo3(Long formatSeqNo3) {
        this.formatSeqNo3 = formatSeqNo3;
    }

    public Long getFormatSeqNo4() {
        return formatSeqNo4;
    }

    public void setFormatSeqNo4(Long formatSeqNo4) {
        this.formatSeqNo4 = formatSeqNo4;
    }

    public Long getFormatSeqNo5() {
        return formatSeqNo5;
    }

    public void setFormatSeqNo5(Long formatSeqNo5) {
        this.formatSeqNo5 = formatSeqNo5;
    }

    public Long getKaitoSeqNo1() {
        return kaitoSeqNo1;
    }

    public void setKaitoSeqNo1(Long kaitoSeqNo1) {
        this.kaitoSeqNo1 = kaitoSeqNo1;
    }

    public Long getKaitoSeqNo2() {
        return kaitoSeqNo2;
    }

    public void setKaitoSeqNo2(Long kaitoSeqNo2) {
        this.kaitoSeqNo2 = kaitoSeqNo2;
    }

    public Long getKaitoSeqNo3() {
        return kaitoSeqNo3;
    }

    public void setKaitoSeqNo3(Long kaitoSeqNo3) {
        this.kaitoSeqNo3 = kaitoSeqNo3;
    }

    public Long getKaitoSeqNo4() {
        return kaitoSeqNo4;
    }

    public void setKaitoSeqNo4(Long kaitoSeqNo4) {
        this.kaitoSeqNo4 = kaitoSeqNo4;
    }

    public Long getKaitoSeqNo5() {
        return kaitoSeqNo5;
    }

    public void setKaitoSeqNo5(Long kaitoSeqNo5) {
        this.kaitoSeqNo5 = kaitoSeqNo5;
    }

    public Long getRefIraiSeqNo1() {
        return refIraiSeqNo1;
    }

    public void setRefIraiSeqNo1(Long refIraiSeqNo1) {
        this.refIraiSeqNo1 = refIraiSeqNo1;
    }

    public Long getRefIraiSeqNo2() {
        return refIraiSeqNo2;
    }

    public void setRefIraiSeqNo2(Long refIraiSeqNo2) {
        this.refIraiSeqNo2 = refIraiSeqNo2;
    }

    public Long getRefIraiSeqNo3() {
        return refIraiSeqNo3;
    }

    public void setRefIraiSeqNo3(Long refIraiSeqNo3) {
        this.refIraiSeqNo3 = refIraiSeqNo3;
    }

    public Long getRefIraiSeqNo4() {
        return refIraiSeqNo4;
    }

    public void setRefIraiSeqNo4(Long refIraiSeqNo4) {
        this.refIraiSeqNo4 = refIraiSeqNo4;
    }

    public Long getRefIraiSeqNo5() {
        return refIraiSeqNo5;
    }

    public void setRefIraiSeqNo5(Long refIraiSeqNo5) {
        this.refIraiSeqNo5 = refIraiSeqNo5;
    }

    public Long getRefKaitoSeqNo1() {
        return refKaitoSeqNo1;
    }

    public void setRefKaitoSeqNo1(Long refKaitoSeqNo1) {
        this.refKaitoSeqNo1 = refKaitoSeqNo1;
    }

    public Long getRefKaitoSeqNo2() {
        return refKaitoSeqNo2;
    }

    public void setRefKaitoSeqNo2(Long refKaitoSeqNo2) {
        this.refKaitoSeqNo2 = refKaitoSeqNo2;
    }

    public Long getRefKaitoSeqNo3() {
        return refKaitoSeqNo3;
    }

    public void setRefKaitoSeqNo3(Long refKaitoSeqNo3) {
        this.refKaitoSeqNo3 = refKaitoSeqNo3;
    }

    public Long getRefKaitoSeqNo4() {
        return refKaitoSeqNo4;
    }

    public void setRefKaitoSeqNo4(Long refKaitoSeqNo4) {
        this.refKaitoSeqNo4 = refKaitoSeqNo4;
    }

    public Long getRefKaitoSeqNo5() {
        return refKaitoSeqNo5;
    }

    public void setRefKaitoSeqNo5(Long refKaitoSeqNo5) {
        this.refKaitoSeqNo5 = refKaitoSeqNo5;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
