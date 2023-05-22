package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id){
        Student student = studentService.getStudent(Long.parseLong(id));
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student , HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return  new ResponseEntity<>(student , HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id){
        studentService.deleteStudent(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping ("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students , HttpStatus.OK);
    }

}
