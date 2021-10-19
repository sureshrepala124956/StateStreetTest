package com.example.stateStreet.test.StateStreetTest.service;

import com.example.stateStreet.test.StateStreetTest.model.Course;
import com.example.stateStreet.test.StateStreetTest.model.Student;
import com.example.stateStreet.test.StateStreetTest.repo.CourseRepo;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

public class CourseServiceImpl implements CourseService{

    private final static Logger LOG = LoggerFactory.getLogger(CourseServiceImpl.class);

    private CourseRepo courseRepo;

    @Override
    public void courseRegisrtaion(Long courseId, Set<Student> students) {
        Optional<Course> courseOptional = courseRepo.findById(courseId);
        if (!courseOptional.isPresent()) {

            LOG.error("Failed to register Student. Invalid CourseId :: " + courseId);
        }
        Course course = courseOptional.get();
        students.addAll(course.getStudents());
        course.setStudents(students);
        courseRepo.save(course);
    }

    @Override
    public Optional<Course> getCourseByCourseName(String courseName) {
        return courseRepo.findCourseByCourseName(courseName);
    }
}
