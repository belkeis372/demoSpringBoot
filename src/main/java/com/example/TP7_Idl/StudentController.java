package com.example.TP7_Idl;

import com.example.TP7_Idl.Student;
import com.example.TP7_Idl.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}