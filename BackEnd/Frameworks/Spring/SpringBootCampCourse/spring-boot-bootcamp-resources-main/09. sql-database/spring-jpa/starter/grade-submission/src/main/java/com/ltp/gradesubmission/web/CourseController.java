package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.Course;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        Course course = courseService.getCourse(id);
        return new ResponseEntity<>(course , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = courseService.getCourses();
        return new ResponseEntity<>(courses , HttpStatus.OK);
    }

}
