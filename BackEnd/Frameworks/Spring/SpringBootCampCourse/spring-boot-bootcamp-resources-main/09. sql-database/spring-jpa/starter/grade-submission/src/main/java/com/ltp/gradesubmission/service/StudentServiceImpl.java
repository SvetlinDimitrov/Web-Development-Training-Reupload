package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exeptions.StudentNotFoundException;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        throw new StudentNotFoundException(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(getStudent(id));
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveAllStudents(List<Student> list) {
        studentRepository.saveAll(list);
    }


}