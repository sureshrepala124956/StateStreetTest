package com.example.stateStreet.test.StateStreetTest.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name="student_id")
    private Long student_id;
    @Column(name="student_name")
    private String student_name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students", cascade=CascadeType.ALL)
    private Set<Course> courses;


    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
