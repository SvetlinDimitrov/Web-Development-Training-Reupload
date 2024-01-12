package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2021.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        if(capacity > employees.size()){
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        Employee toRemove = employees.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
        if(toRemove != null){
            employees.remove(toRemove);
            return true;
        }
        return false;
    }
    public Employee getOldestEmployee(){
        return employees.stream().max((f,s) -> Integer.compare(f.getAge(),s.getAge())).orElse(null);
    }

    public Employee getEmployee(String name){
        return employees.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("Employees working at Cafe %s:%n",name));
        for (Employee employee : employees) {
            print.append(String.format("%s%n",employee));
        }
        return print.toString();
    }

}
