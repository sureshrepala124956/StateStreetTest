package com.example.stateStreet.test.StateStreetTest.repo;

import com.example.stateStreet.test.StateStreetTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
