package com.example.student_management.service;

import com.example.student_management.dto.UserRegistrationDto;
import com.example.student_management.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);

}
