package com.toray.ojt.web.dto;

import java.util.Date;

public class BaseInfoDTO {
    private String title;
    private Date endYmd;
    private String importantFlg;

    public BaseInfoDTO() {
    }

    public BaseInfoDTO(String title, Date endYmd, String importantFlg) {
        this.title = title;
        this.endYmd = endYmd;
        this.importantFlg = importantFlg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndYmd() {
        return endYmd;
    }

    public void setEndYmd(Date endYmd) {
        this.endYmd = endYmd;
    }

    public String getImportantFlg() {
        return importantFlg;
    }

    public void setImportantFlg(String importantFlg) {
        this.importantFlg = importantFlg;
    }
}
