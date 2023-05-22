package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    private Map<Long , Student> map = new HashMap<>();

    public Student getStudent(Long id){
        return map.get(id);
    }

    public void saveStudent(Student student) {
        map.put(student.getId() , student);
    }

    public void deleteStudent(Long id) {
        map.remove(id);
    }

    public List<Student> getStudents() {
        return map.values().stream().toList();
    }
}
