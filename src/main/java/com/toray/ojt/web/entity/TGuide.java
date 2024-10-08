package com.toray.ojt.web.entity;

import java.util.Date;

public class TGuide {
    private Date crtTimestamp;
    private String crtUserId;
    private Date updTimestamp;
    private String updUserId;
    private Long seqGuide;  // Primary Key
    private Date beginYmd;
    private Date endYmd;
    private String importantFlg;
    private String title;
    private String text;
    private Long attachClassNo;
}
