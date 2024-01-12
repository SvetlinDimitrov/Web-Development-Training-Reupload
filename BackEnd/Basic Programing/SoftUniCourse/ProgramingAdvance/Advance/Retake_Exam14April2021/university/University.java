package JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public  int getStudentCount(){
        return students.size();
    }
    public String registerStudent(Student student){
        StringBuilder print = new StringBuilder();
        boolean isThereTheSameStudent = students.contains(student);
        boolean spaceNeeded = capacity > students.size();
        if(!isThereTheSameStudent && spaceNeeded){
            print.append(String.format( "Added student %s %s",student.getFirstName(), student.getLastName()));
            students.add(student);
        }else if (isThereTheSameStudent && !spaceNeeded){
            print.append(String.format("Student is already in the JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021.university%n"));
            print.append("No seats in the JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021.university");
        }else if (isThereTheSameStudent){
            print.append(String.format("Student is already in the JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021.university%n"));
        }else {
            print.append("No seats in the JavaAdvance.Exams.Java_Advanced_Retake_Exam14April2021.university");
        }
        return print.toString();
    }
    public String dismissStudent(Student student){
        if(students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",student.getFirstName() , student.getLastName());
        }else{
            return "Student not found";
        }
    }
    public Student getStudent(String firstName, String lastName){
        return students.stream().filter(e-> e.getFirstName().equals(firstName)&& e.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }
    public String getStatistics(){
        StringBuilder print = new StringBuilder();
        for (Student student : students) {
            print.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n"
                    ,student.getFirstName(),student.getLastName(),student.getBestSubject()));
        }
        return print.toString();
    }
}
