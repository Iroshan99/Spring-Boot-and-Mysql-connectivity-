package com.example.test3.controller;

import com.example.test3.entity.Student;
import com.example.test3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/registerStudent")
    public void saveStudent(@RequestBody Student student){
        studentService.put(student.getName(),student.getAge());

    }

}
