package com.toray.ojt.web.dto;

import java.sql.Date;
import java.sql.Timestamp;


public class BaseInfoSearchDto {


    private String importantFlg;
    private String title;
    private String text;
    private Date beginYmd;
    private Date endYmd;
    private Timestamp updTimestamp;

    public String getImportantFlg() {
        return importantFlg;
    }

    public void setImportantFlg(String importantFlg) {
        this.importantFlg = importantFlg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Date getBeginYmd() {
        return beginYmd;
    }

    public void setBeginYmd(Date beginYmd) {
        this.beginYmd = beginYmd;
    }

    public Date getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(Date endYmd) {
        this.endYmd = endYmd;
    }

    public Timestamp getUpdTimestamp() {
        return updTimestamp;
    }

    public void setUpdTimestamp(Timestamp updTimestamp) {
        this.updTimestamp = updTimestamp;
    }
}
