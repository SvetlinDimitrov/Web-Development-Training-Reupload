package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.exeptions.CourseNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            return course.get();
        }
       throw new CourseNotFoundException(id);
    }

    @Override
    public Course saveCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(getCourse(id));
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveAllCourses(List<Course> courses) {
        courseRepository.saveAll(courses);
    }


}
