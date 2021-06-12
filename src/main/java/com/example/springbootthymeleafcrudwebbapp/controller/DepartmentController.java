package com.example.springbootthymeleafcrudwebbapp.controller;

import com.example.springbootthymeleafcrudwebbapp.model.Department;
import com.example.springbootthymeleafcrudwebbapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/showNewDepartmentForm")
    public String showAllDepartments(Model model) {
        model.addAttribute("listDepartments", departmentService.getAllDepartments());
        return "departments";
    }

//    @GetMapping("/showNewDepartmentForm")
//    public String showNewDepartmentForm(Model model) {
//        Department department = new Department();
//        model.addAttribute("department", department);
//        return "new_department";
//    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }


}
