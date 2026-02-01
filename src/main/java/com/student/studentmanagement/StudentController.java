package com.student.studentmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students";
    }

    @GetMapping("/students/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute Student student) {

        if (student.getId() != null) {
            Student existingStudent = repository.findById(student.getId()).orElse(null);

            if (existingStudent != null) {
                existingStudent.setName(student.getName());
                existingStudent.setRegistrationNo(student.getRegistrationNo());
                existingStudent.setEmail(student.getEmail());
                existingStudent.setCourse(student.getCourse());
                repository.save(existingStudent);
            }

        } else {
            repository.save(student);
        }

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("student", student);
        return "student-form";
    }

    

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/deleteAll")
    public String deleteAllStudents() {
        repository.deleteAll();
        return "redirect:/students";
    }
}

