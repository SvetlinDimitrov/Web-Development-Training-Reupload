package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class School implements Iterable<Student>{
    private ArrayList<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void addListOfStudents(Collection<Student> student){
        students.addAll(student);
    }


    @Override
    public Iterator<Student> iterator() {
        return new Iterator<>() {
            static Integer index = 0;

            @Override
            public boolean hasNext() {
                return index < students.size();
            }

            @Override
            public Student next() {
                if(hasNext()){
                    return students.get(index++);
                }
                return null;
            }
        };
    }
}
