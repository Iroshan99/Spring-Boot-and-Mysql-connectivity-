package com.example.test3.service;

import com.example.test3.entity.Student;
import com.example.test3.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private Student student;

    @Autowired
    private StudentRepo studentRepo;



    public void put(String name,int age){
        Student newStudent=new Student();
        newStudent.setName(name);
        newStudent.setAge(age);

        studentRepo.save(newStudent);


    }
}
