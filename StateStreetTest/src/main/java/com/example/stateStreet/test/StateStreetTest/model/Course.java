package com.example.stateStreet.test.StateStreetTest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
public class Course implements Serializable {
    @Id
    @Column(name = "COURSE_ID", unique = true, nullable = false, length = 20)
    private Long courseId;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = {
            @JoinColumn(name = "COURSE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) })
    private Set<Student> students;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
