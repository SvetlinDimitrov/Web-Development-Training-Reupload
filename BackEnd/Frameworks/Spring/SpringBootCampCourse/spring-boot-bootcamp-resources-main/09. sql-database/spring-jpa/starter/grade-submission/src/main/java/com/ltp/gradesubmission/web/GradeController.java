package com.ltp.gradesubmission.web;

import java.util.List;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.GradeService;
import com.ltp.gradesubmission.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.Grade;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final StudentService studentService;
    private final GradeService gradeService;

    public GradeController(StudentService studentService, GradeService gradeService) {
        this.studentService = studentService;

        this.gradeService = gradeService;
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        Grade grade = gradeService.getGrade(studentId, courseId);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
        Grade saved = gradeService.saveGrade(grade, studentId, courseId);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
        Grade updateGrade = gradeService.updateGrade(grade.getScore(), studentId, courseId);
        return new ResponseEntity<>(updateGrade, HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        gradeService.deleteGrade(studentId , courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
        List<Grade> studentGrades = gradeService.getStudentGrades(studentId);
        return new ResponseEntity<>(studentGrades ,HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId) {
        List<Grade> courseGrades = gradeService.getCourseGrades(courseId);
        return new ResponseEntity<>(courseGrades , HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getGrades() {
        List<Grade> allGrades = gradeService.getAllGrades();
        return new ResponseEntity<>(allGrades,HttpStatus.OK);
    }

}
