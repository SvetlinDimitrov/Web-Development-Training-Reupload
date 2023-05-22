package com.ltp.gradesubmission.exeptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("The student id '" + id + "' does not exist in our records");
    }

}