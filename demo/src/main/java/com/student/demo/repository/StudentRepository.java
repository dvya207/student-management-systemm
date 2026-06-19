package com.student.demo.repository;

import com.student.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ADD STUDENT
    public int addStudent(Student student) {

        String sql =
                "INSERT INTO students(name, grade_level, email) VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getGradeLevel(),
                student.getEmail()
        );
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("grade_level")
                ));
    }

    // GET STUDENT BY ID
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id=?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("grade_level")
                ),
                id
        );
    }

    // UPDATE STUDENT
    public int updateStudent(Student student) {

        String sql =
                "UPDATE students SET name=?, grade_level=?, email=? WHERE id=?";

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getGradeLevel(),
                student.getEmail(),
                student.getId()
        );
    }

    // DELETE STUDENT
    public int deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        return jdbcTemplate.update(sql, id);
    }
}