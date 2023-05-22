package JavaAdvance.Exercises_Defining_Classes.Company_Roster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();
        int times = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < times; i++) {
            String [] input = scanner.nextLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department =input[3];

            switch (input.length){
                case 4:
                list.add(new Employee(name,salary,position,department));
                break;
                case 5:
                    try {
                        list.add(new Employee(name,salary,position,department,Integer.parseInt(input[4])));
                    }catch (Exception e){
                        list.add(new Employee(name,salary,position,department,input[4]));
                    }
                    break;
                case 6:
                    list.add(new Employee(name,salary,position,department,input[4] , Integer.parseInt(input[5])));
            }
        }
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String nameDep = list.get(i).getDepartment();
            boolean isEmpty = departments.stream()
                    .anyMatch(department -> department.getName().equals(nameDep));
            if(!isEmpty){
                departments.add(new Department(nameDep));
            }
            departments.get(IndexOfMotherFucker(departments,nameDep)).setPeoples(list.get(i));
        }

        Department HightDep = departments.stream()
                .sorted((dep2 ,dep1) -> Double.compare(
                        dep1.getPeoples().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        dep2.getPeoples().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .max(Comparator.comparing(Department::AverageSalary)
                ).get();

        System.out.printf("Highest Average Salary: %s%n",HightDep.getName());
        HightDep.getPeoples()
                .stream().sorted((people1 , people2) -> Double.compare(people2.getSalary(), people1.getSalary()))
                .forEach(employee -> {
            System.out.printf("%s %.2f %s %d%n",
                    employee.getName(),employee.getSalary(),
                    employee.getEmail(),employee.getAge());
        });

    }
    public static int IndexOfMotherFucker(List<Department> list ,String dep ){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(dep)){
                return i;
            }

        }
        return -1;
    }
}
