package com.student.studentmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final StudentRepository repository;

    public HomeController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        long total = repository.count();   // 🔥 real database count
        model.addAttribute("totalStudents", total);
        return "home";
    }
}

