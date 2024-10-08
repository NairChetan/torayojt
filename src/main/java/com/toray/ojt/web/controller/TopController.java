package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.BaseInfoDTO;
import com.toray.ojt.web.dto.TGuideDTO;
import com.toray.ojt.web.service.BaseInfoService;
import com.toray.ojt.web.service.TGuideService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TopController {

    private final BaseInfoService baseInfoService;
    private final TGuideService tGuideService;

    public TopController(BaseInfoService baseInfoService, TGuideService tGuideService) {
        this.baseInfoService = baseInfoService;
        this.tGuideService = tGuideService;
    }


    @GetMapping("/toppage")
    public String getTopPage(Model model, HttpSession session) {
        List<BaseInfoDTO> baseInfos= baseInfoService.getBaseInfo();
        List< TGuideDTO> tGuides=tGuideService.getTGuide();

        model.addAttribute("baseInfos", baseInfos);
        model.addAttribute("tGuides",tGuides);
        model.addAttribute("userNameEn",session.getAttribute("userNameEn"));
        model.addAttribute("userId",session.getAttribute("userId"));
        return "/layout/top";
    }

}
