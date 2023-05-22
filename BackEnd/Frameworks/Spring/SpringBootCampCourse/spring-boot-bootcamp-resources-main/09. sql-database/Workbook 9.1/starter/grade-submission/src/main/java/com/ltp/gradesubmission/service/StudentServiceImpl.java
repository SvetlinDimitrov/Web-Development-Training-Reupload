package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.getStudent(id);
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.saveStudent(student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }


}