package com.example.test3.service;

import com.example.test3.entity.Student;
import com.example.test3.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(new Student());
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {

        Optional<Student> student1=studentRepo.findById(id);

        if(student1.isPresent()) {
            Student student2 = student1.get();

            student2.setName(student.getName());
            student2.setAge(student.getAge());
            return studentRepo.save(student2);

        }

        else {
            return null;
        }



    }
}
