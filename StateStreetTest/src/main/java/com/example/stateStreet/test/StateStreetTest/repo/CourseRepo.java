package com.example.stateStreet.test.StateStreetTest.repo;

import com.example.stateStreet.test.StateStreetTest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {

    public Optional<Course> findCourseByCourseName(String courseName);

}
