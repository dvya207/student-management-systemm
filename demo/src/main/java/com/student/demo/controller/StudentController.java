package com.student.demo.controller;

import com.student.demo.model.Student;
import com.student.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ADD STUDENT
    @PostMapping
    public String addStudent(@RequestBody Student student) {

        service.addStudent(student);

        return "Student Added Successfully";
    }

    // GET ALL STUDENTS
    @GetMapping
    public List<Student> getStudents() {

        return service.getAllStudents();
    }

    // GET STUDENT BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {

        return service.getStudentById(id);
    }

    // UPDATE STUDENT
    @PutMapping("/{id}")
    public String updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        student.setId(id);

        service.updateStudent(student);

        return "Student Updated Successfully";
    }

    // DELETE STUDENT
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        service.deleteStudent(id);

        return "Student Deleted Successfully";
    }
}