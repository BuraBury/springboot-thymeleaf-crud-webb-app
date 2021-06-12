package com.example.springbootthymeleafcrudwebbapp.controller;

import com.example.springbootthymeleafcrudwebbapp.model.Position;
import com.example.springbootthymeleafcrudwebbapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        Position position = new Position();
        model.addAttribute("position", position);
        return "positions";
    }
    @PostMapping("/savePosition")
    public String savePosition(@ModelAttribute("position") Position position) {
        positionService.savePosition(position);
        return "redirect:/";
    }

    @GetMapping("/deletePosition/{id}")
    public String deletePosition(@PathVariable(value = "id") long id) {
        this.positionService.deletePositionById(id);
        return "redirect:/";
    }

}
