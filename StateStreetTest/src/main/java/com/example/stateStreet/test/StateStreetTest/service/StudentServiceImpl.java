package com.example.stateStreet.test.StateStreetTest.service;

import com.example.stateStreet.test.StateStreetTest.model.Course;
import com.example.stateStreet.test.StateStreetTest.model.Student;
import com.example.stateStreet.test.StateStreetTest.repo.StudentRepo;
import jdk.jpackage.internal.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class StudentServiceImpl implements StudentService{

    private final static Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepo studentRepo;
    private CourseService courseService;

    public Long addStudent(Student student) {
        student = studentRepo.save(student);
        return student.getStudent_id();
    }

    @Override
    public Set<Student> getStudentsByCourseName(String courseName) {
        Optional<Course> course = courseService.getCourseByCourseName(courseName);
        if (!course.isPresent()) {
            Log.error("Not able to get Students::::::::: " + courseName);
        }
        Comparator<Student> studentByName = (Student student1, Student student2) -> student1.getStudent_name()
                .compareTo(student2.getStudent_name());
        TreeSet<Student> sortedStudents = new TreeSet<>(studentByName);

        Set<Student> students = course.get().getStudents();
        students.forEach(student -> student.setCourses(null));
        sortedStudents.addAll(students);
        return sortedStudents;
    }

    @Override
    public void deleteStudent(Long studentId) {
        Optional<Student> student = studentRepo.findById(studentId);
        if (!student.isPresent()) {
            Log.error("Unable to find Student:::::::::::: " + studentId);
        }
        studentRepo.delete(student.get());
    }

}
