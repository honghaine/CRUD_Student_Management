package com.example.student_management.service;

import com.example.student_management.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(Long id);
}
