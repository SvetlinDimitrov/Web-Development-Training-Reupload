package JavaAdvance.Exercises_Defining_Classes.Company_Roster_02;

import java.util.ArrayList;

public class Department {
    private String name ;
    private ArrayList<Employee> peoples;

    public Department(String name){
        this.name = name;
        peoples = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeoples(Employee peoples) {
        this.peoples.add(peoples);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Employee> getPeoples() {
        return peoples;
    }

    public double AverageSalary(){
        double sum=0;
        for (int i = 0; i < peoples.size(); i++) {
            sum+=peoples.get(i).getSalary();
        }
        return sum/peoples.size();
    }
}
