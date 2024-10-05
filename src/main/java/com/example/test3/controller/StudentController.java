package com.example.test3.controller;

import com.example.test3.entity.Student;
import com.example.test3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/registerStudent")
    public void saveStudent(@RequestBody Student student){
        studentService.put(student.getName(),student.getAge());

    }

    @GetMapping(value = "/getstudent/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);

    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody Student student){

        studentService.updateStudent(id,student);

        if(student!=null){
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("not updated",HttpStatus.BAD_REQUEST);
        }

    }




}
