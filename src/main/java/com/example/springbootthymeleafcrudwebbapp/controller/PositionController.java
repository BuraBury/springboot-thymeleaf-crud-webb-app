package com.example.springbootthymeleafcrudwebbapp.controller;

import com.example.springbootthymeleafcrudwebbapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/showNewPositionForm")
    public String showAllDepartments(Model model) {
        model.addAttribute("listPositions", positionService.getAllPositions());
        return "positions";
    }

}
