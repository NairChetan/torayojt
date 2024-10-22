package com.toray.ojt.web.dto;

public class BaseAttachmentSelectDto {
    private byte[] fileObject;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileObject() {
        return fileObject;
    }

    public void setFileObject(byte[] fileObject) {
        this.fileObject = fileObject;
    }

    public BaseAttachmentSelectDto(byte[] fileObject,String fileName) {
        this.fileObject = fileObject;
        this.fileName = fileName;
    }

    public BaseAttachmentSelectDto() {
    }
}
