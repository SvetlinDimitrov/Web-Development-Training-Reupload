package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository  extends JpaRepository<Grade, Long> {
    Optional<Grade> findByStudentIdAndCourseId(Long studentId , Long courseId);
    List<Grade> findAllByCourseId(Long courseId);
    List<Grade> findAllByStudentId(Long studentId);

}