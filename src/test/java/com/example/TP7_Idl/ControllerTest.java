package com.example.TP7_Idl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    void shouldSaveStudent() {
        Student student = new Student();
        student.setName("Charlie");
        student.setAddress("Algeria");
        studentRepository.save(student);
        // يتأكد من أنه تم حفظ طالب واحد بالفعل
        assertThat(studentRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindAllStudents() {
        // يتأكد من إمكانية استرجاع الطالب
        assertThat(studentRepository.findAll()).hasSize(1);
    }
}