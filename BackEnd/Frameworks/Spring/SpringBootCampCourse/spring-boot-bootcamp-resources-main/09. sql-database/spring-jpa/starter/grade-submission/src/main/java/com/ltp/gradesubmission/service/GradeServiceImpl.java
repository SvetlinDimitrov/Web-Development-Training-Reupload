package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exeptions.GradeNotFoundException;
import com.ltp.gradesubmission.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if(grade.isPresent()){
            return grade.get();
        }
        throw new GradeNotFoundException(studentId , courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);
        grade.setCourse(course);
        grade.setStudent(student);
        return gradeRepository.saveAndFlush(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Grade grade = getGrade(studentId, courseId);
        grade.setScore(score);
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        Grade grade = getGrade(studentId, courseId);
        gradeRepository.delete(grade);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findAllByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
       return gradeRepository.findAll();
    }

}
