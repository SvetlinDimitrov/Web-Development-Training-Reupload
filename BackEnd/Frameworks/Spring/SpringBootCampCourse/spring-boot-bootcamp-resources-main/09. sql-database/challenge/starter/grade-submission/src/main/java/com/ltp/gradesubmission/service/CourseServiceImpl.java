package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudentService studentService;
    
    @Override
    public Course getCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return unwrapCourse(course, id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {  
        courseRepository.deleteById(id);      
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public Course addStudentToCourse(Long studentId, Long courseId) {
        Course course = getCourse(courseId);
        Student student = studentService.getStudent(studentId);
        course.getStudents().add(student);
        return saveCourse(course);
    }

    @Override
    public List<Student> getEnrolledStudents(Long id) {
        Course course = getCourse(id);
        return course.getStudents();
    }

    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }


}
