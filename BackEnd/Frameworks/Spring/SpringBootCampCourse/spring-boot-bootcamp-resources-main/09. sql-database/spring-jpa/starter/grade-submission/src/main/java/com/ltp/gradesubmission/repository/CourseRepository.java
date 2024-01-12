package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course , Long> {

}