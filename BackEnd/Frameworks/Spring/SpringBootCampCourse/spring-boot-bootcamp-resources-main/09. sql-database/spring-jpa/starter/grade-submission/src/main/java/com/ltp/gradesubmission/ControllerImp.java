package com.ltp.gradesubmission;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.service.CourseService;
import com.ltp.gradesubmission.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class ControllerImp implements CommandLineRunner {

    StudentService studentService;
    CourseService courseService;

    @Override
    public void run(String... args) throws Exception {
        Student[] students = new Student[] {
                new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
                new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
                new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
                new Student("Neville Longbottom", LocalDate.parse(("1980-07-30")))
        };
        studentService.saveAllStudents(Arrays.stream(students).toList());
        List<Course> courses = Arrays.stream(new Course[] {
                new Course("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
                new Course("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
                new Course("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
                new Course("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
                new Course("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
                new Course("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
        }).toList();

        courseService.saveAllCourses(courses);
    }
}
