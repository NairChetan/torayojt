package com.toray.ojt.web.dto;

import java.sql.Timestamp;

public class BaseAttachmentInsertDto {
    private Long attachClassNo;
    private String fileName;
    private Long fileSize;
    private byte[] fileObject;
    private Timestamp updTimestamp;
    private String updUserid;
    private String crtUserid;
    private String deleteFlg = "N";

    public BaseAttachmentInsertDto() {}

    public BaseAttachmentInsertDto(Long attachClassNo, String fileName, Long fileSize, byte[] fileObject,
                                   Timestamp updTimestamp, String updUserid, String crtUserid,String deleteFlg) {
        this.attachClassNo = attachClassNo;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileObject = fileObject;
        this.updTimestamp = updTimestamp;
        this.updUserid = updUserid;
        this.crtUserid = crtUserid;
        this.deleteFlg = deleteFlg;
    }

    public Long getAttachClassNo() {
        return attachClassNo;
    }

    public void setAttachClassNo(Long attachClassNo) {
        this.attachClassNo = attachClassNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileObject() {
        return fileObject;
    }

    public void setFileObject(byte[] fileObject) {
        this.fileObject = fileObject;
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

    public String getCrtUserid() {
        return crtUserid;
    }

    public void setCrtUserid(String crtUserid) {
        this.crtUserid = crtUserid;
    }


    public String getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }
}
