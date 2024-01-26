import java.util.Iterator;

public class Main {

  public static void main(String[] args) {

    Employee zak = new Employee("Zak");
    Employee sarah = new Employee("Sarah");
    Employee anna = new Employee("Anna");

    StaffList staffList = new StaffList(zak , sarah , anna);
    Iterator<Employee> iterator = staffList.iterator();

    while(iterator.hasNext()){
      System.out.println(iterator.next().getName());
    }
  }

}
