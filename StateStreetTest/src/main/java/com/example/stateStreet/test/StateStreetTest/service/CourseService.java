package com.example.stateStreet.test.StateStreetTest.service;

import com.example.stateStreet.test.StateStreetTest.model.Course;
import com.example.stateStreet.test.StateStreetTest.model.Student;

import java.util.Optional;
import java.util.Set;

public interface CourseService {

    public void courseRegisrtaion(Long courseId, Set<Student> students);
    public Optional<Course> getCourseByCourseName(String courseName);
}
