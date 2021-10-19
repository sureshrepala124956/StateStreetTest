package com.example.stateStreet.test.StateStreetTest.service;

import com.example.stateStreet.test.StateStreetTest.model.Student;

import java.util.Set;


public interface StudentService {

    public Long addStudent(Student student);
    public Set<Student> getStudentsByCourseName(String courseName);
    public void deleteStudent(Long studentId);

}
