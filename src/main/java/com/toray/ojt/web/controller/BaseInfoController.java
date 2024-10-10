package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.*;
import com.toray.ojt.web.service.BaseInfoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class BaseInfoController {
    private final BaseInfoService baseInfoService;

    public BaseInfoController(BaseInfoService baseInfoService) {

        this.baseInfoService = baseInfoService;
    }

    @GetMapping("/search")
    public String searchBaseInfo(@RequestParam(required = false) String title,
                                 @RequestParam(required = false) String text,
                                 @RequestParam(required = false) String importantFlg,
                                 @RequestParam(required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd") Date endYmd,
                                 Model model) {

        // Check if search parameters are empty (initial page load)
        if (title == null && text == null && importantFlg == null && endYmd == null) {
            // Do not perform the search, simply return the page with no results
            model.addAttribute("baseInfos", Collections.emptyList());
            return "layout/noticesearch"; // Thymeleaf template name
        }


        // Populate the search DTO with the request parameters
        BaseInfoSearchDto searchDto = new BaseInfoSearchDto();
        searchDto.setTitle(title);
        searchDto.setText(text);
        searchDto.setImportantFlg(importantFlg);
        searchDto.setEndYmd(endYmd);
        System.out.println("importantFlg: " + importantFlg);
        System.out.println("Received endYmd: " + endYmd);

        // Pass the search DTO to the service
        List<BaseInfoSearchDto> baseInfos = baseInfoService.searchBaseInfo(searchDto);

        // Add the result to the model for Thymeleaf to render
        model.addAttribute("baseInfos", baseInfos);

        return "layout/noticesearch"; // Thymeleaf template name
    }
// to get the roles in the openlist
    @GetMapping("/roles")
    public ResponseEntity<List<BaseinfoViewRoleNameGetDto>> getRoles() {
        List<BaseinfoViewRoleNameGetDto> roles = baseInfoService.getRoles();
        return ResponseEntity.ok(roles);
    }


    // Add this method to handle the GET request and load the form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Add any necessary attributes to the model if needed
        return "layout/noticeinsert"; // This should match the Thymeleaf template you want to display
    }

    @PostMapping("/register")
    public String registerBaseInfo(@ModelAttribute BaseInfoInsertDto baseInfoInsertDto,
                                   @RequestParam List<String> roles, // Getting checked roles from the form
                                   Model model) {

        // Step 1: Insert base info into `base_info` table
        Long seqInfo = baseInfoService.insertBaseInfo(baseInfoInsertDto);
         System.out.println(seqInfo);

        // Step 2: Map roles to the `base_info_view_role` table using the inserted `seqInfo`
        for (String role : roles) {
            BaseInfoViewRoleInsertDto roleInsertDto = new BaseInfoViewRoleInsertDto();
            roleInsertDto.setSeqInfo(seqInfo);
            roleInsertDto.setRole(role);
            baseInfoService.insertBaseInfoRole(roleInsertDto);
        }

        // Optionally, you can add success messages or handle any validation issues here
        model.addAttribute("message", "Content registered successfully!");

        // Redirect to some view, perhaps the same form page or a confirmation page
        return "layout/noticeinsert"; // Change to the actual form page or success page
    }


    @GetMapping("/noticeDetail/{seqInfo}")
    public String getNoticeDetail(@PathVariable Long seqInfo, Model model) {
        BaseInfoDetailsBasedOnSeqInfoDto notice = baseInfoService.getBaseInfoBySeqInfo(seqInfo);
        System.out.println(notice.getSeqInfo());
        model.addAttribute("notice", notice);
        return "layout/noticeDetails";  // The Thymeleaf view name
    }


    @GetMapping("/noticeDetail/roles/{seqInfo}")
    public ResponseEntity<List<String>> getRolesBySeqInfo(@PathVariable Long seqInfo) {
        // Fetch the list of DTOs from the service
        List<BaseInfoRoleBasedOnSeqInfoDto> roleDtos = baseInfoService.getRolesBySeqInfo(seqInfo);

        // Map the DTOs to extract only the role names (Strings)
        List<String> roles = roleDtos.stream()
                .map(BaseInfoRoleBasedOnSeqInfoDto::getRole) // Assuming getRole() returns the role name as String
                .collect(Collectors.toList());

        return ResponseEntity.ok(roles); // Return the list of role names
    }

    @DeleteMapping("/{seqInfo}")
    public ResponseEntity<Void> deleteBaseInfo(@PathVariable Long seqInfo) {
        baseInfoService.deleteBaseInfoBySeqInfo(seqInfo);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
