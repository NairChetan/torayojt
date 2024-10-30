package com.toray.ojt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @GetMapping("/Test")
    public String getTest(Model model) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).mapToInt(Integer::intValue).sum();  // Calculate sum
        model.addAttribute("numbers", numbers);
        model.addAttribute("sum", sum); // Add sum to the model
        return "layout/Test";
    }
    @GetMapping("/mymap")
    public String getMap(Model model){
        Map<String,String> myMap = new HashMap<>();
        myMap.put("name","Sreeson");
        myMap.put("city", "Kochi");
        myMap.put("hobby", "Sleeping");

        // Adding the map to the model
        model.addAttribute("myMap", myMap);
        return "layout/ObjectTest";
    }
}