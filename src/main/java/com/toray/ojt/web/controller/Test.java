package com.toray.ojt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/noticeDetails")
    public String getNoticePage() {
        return "layout/noticeDetails";
    }

    @GetMapping("/noticeUpdate")
    public String getNoticeUpdate() {
        return "layout/noticeUpdate";
    }

}
