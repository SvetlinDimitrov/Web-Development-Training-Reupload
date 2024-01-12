package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
