package com.example.stateStreet.test.StateStreetTest.controller;

import com.example.stateStreet.test.StateStreetTest.model.Student;
import com.example.stateStreet.test.StateStreetTest.service.CourseService;
import com.example.stateStreet.test.StateStreetTest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class StateStreetController {


    private StudentService studentService;
    private CourseService courseService;

    /**
     * As per the problem this endpoint will enrol the student to course
     * @param courseId
     * @param students
     * @return
     */

    @PutMapping("/registerStudentsToCourse/{courseId}")
    public String courseRegisrtaion(@PathVariable Long courseId, @RequestBody Set<Student> students) {
        courseService.courseRegisrtaion(courseId, students);
        return "Students has been successfully Enrolled to Course :: " + courseId;
    }

    /**
     * As per the problem this endpoint will fetch the Students by coursename
     * @param courseName
     * @return
     */
    @GetMapping("/studentsByCourseName/{courseName}")
    public Set<Student> getStudentsByCourseName(@PathVariable String courseName) {
        return studentService.getStudentsByCourseName(courseName);
    }

    /**
     * Removed Student
     * @param studentId
     * @return
     */
    @DeleteMapping("/student/{studentId}")
    public String deleteStudent(Long studentId) {
        studentService.deleteStudent(studentId);
        return "Student Deletion Successful";
    }

    @GetMapping("/")
    public String getMessage() {
        return "Welcome to Bank!!";
    }
    
}
