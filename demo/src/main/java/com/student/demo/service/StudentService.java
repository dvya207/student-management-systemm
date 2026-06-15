package com.student.demo.service;

import com.student.demo.model.Student;
import com.student.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // ADD STUDENT
    public int addStudent(Student student) {
        return repository.addStudent(student);
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    // GET STUDENT BY ID
    public Student getStudentById(int id) {
        return repository.getStudentById(id);
    }

    // UPDATE STUDENT
    public int updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    // DELETE STUDENT
    public int deleteStudent(int id) {
        return repository.deleteStudent(id);
    }
}