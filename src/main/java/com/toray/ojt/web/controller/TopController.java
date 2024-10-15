package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.BaseInfoDTO;
import com.toray.ojt.web.dto.TGuideDTO;
import com.toray.ojt.web.dto.ToDoDTO;
import com.toray.ojt.web.service.BaseInfoService;
import com.toray.ojt.web.service.TGuideService;
import jakarta.servlet.http.HttpSession;
import com.toray.ojt.web.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class TopController {

    private final BaseInfoService baseInfoService;
    private final TGuideService tGuideService;
    private final ToDoService toDoService;

    public TopController(BaseInfoService baseInfoService, TGuideService tGuideService, ToDoService toDoService) {
        this.baseInfoService = baseInfoService;
        this.tGuideService = tGuideService;
        this.toDoService = toDoService;
    }


    @GetMapping("/toppage")
    public String getTopPage(@RequestParam(name = "lang", required = false) String lang, Locale locale, Model model) {
        String language = (lang != null) ? lang : locale.getLanguage();  // Default to the locale if no lang param

        List<BaseInfoDTO> baseInfos = baseInfoService.getBaseInfo();
        List<TGuideDTO> tGuides = tGuideService.getTGuide();
        List<ToDoDTO> toDo = toDoService.getToDoByLocale(language);

        model.addAttribute("baseInfos", baseInfos);
        model.addAttribute("tGuides", tGuides);
        model.addAttribute("toDo", toDo);

        return "/layout/top";
    }

}
