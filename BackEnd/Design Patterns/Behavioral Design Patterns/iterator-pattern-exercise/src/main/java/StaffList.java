import java.util.Iterator;

public class StaffList implements Iterable<Employee>{
    private final Employee[] employees;

    public StaffList(Employee...employees) {
        this.employees = employees;
    }


    @Override
    public Iterator<Employee> iterator() {
        return new StaffListIterator(this);
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
