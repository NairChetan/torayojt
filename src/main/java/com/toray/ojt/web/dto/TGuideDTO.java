package com.toray.ojt.web.dto;

import java.util.Date;

public class TGuideDTO {
    private String title;
    private Date beginYmd;
    private String importantFlg;

    public TGuideDTO() {
    }

    public TGuideDTO(String title, Date beginYmd, String importantFlg) {
        this.title = title;
        this.beginYmd = beginYmd;
        this.importantFlg = importantFlg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginYmd() {
        return beginYmd;
    }

    public void setBeginYmd(Date beginYmd) {
        this.beginYmd = beginYmd;
    }

    public String getImportantFlg() {
        return importantFlg;
    }

    public void setImportantFlg(String importantFlg) {
        this.importantFlg = importantFlg;
    }
}
