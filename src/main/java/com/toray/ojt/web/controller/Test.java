package com.toray.ojt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/noticepage")
    public String getNoticePage() {
        return "layout/noticeinsert";
    }

}
