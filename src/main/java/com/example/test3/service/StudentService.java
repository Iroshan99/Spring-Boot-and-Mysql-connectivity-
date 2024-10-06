package com.example.test3.service;

import com.example.test3.entity.Student;
import com.example.test3.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void put(Student student, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            student.setImageName(image.getOriginalFilename());
            student.setImageType(image.getContentType());
            student.setImageData(image.getBytes());
        } else {
            throw new RuntimeException("Image is required");
        }
        studentRepo.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    public void updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            Student studentToUpdate = existingStudent.get();
            studentToUpdate.setName(student.getName());
            studentToUpdate.setAge(student.getAge());
            studentRepo.save(studentToUpdate);
        } else {
            throw new RuntimeException("Student not found");
        }
    }
}
