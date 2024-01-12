package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.pojo.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    GradeService gradeService;




    @Test
    void getGradeIndex() {
        Grade grade = new Grade("UNGA" , "KOtki" , "B+");

        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        assertEquals(gradeService.getGrades().get(0).getId() , grade.getId());
    }


    @Test
    void getGradeById() {
    }

    @Test
    void submitGrade() {
    }
}