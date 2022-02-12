package com.example.student_management.controller;


import com.example.student_management.entity.Student;
import com.example.student_management.entity.Teacher;
import com.example.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        super();
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String getAllTeacher(Model model) {
        model.addAttribute("teachers",teacherService.getAllTeachers());
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teachers", teacher);
        return "form/createFormTeacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute(name = "teachers") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String updateTeacher(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_teacher";
    }


    @PostMapping("/teachers/{id}")
    public String editTeacher(@PathVariable Long id, @ModelAttribute(name = "teacher") Teacher teacher, Model model) {
        Teacher existingTeacher = teacherService.getTeacherById(id);

        existingTeacher.setId(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());

        teacherService.updateTeacher(existingTeacher);
        return "redirect:/teachers";
    }


    @GetMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id, Model model) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }

}
