package com.example.student_management.controller;


import com.example.student_management.dto.UserRegistrationDto;
import com.example.student_management.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "/signup/signup";
    }


    @PostMapping
    public String createUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/signup?success";
    }


}
