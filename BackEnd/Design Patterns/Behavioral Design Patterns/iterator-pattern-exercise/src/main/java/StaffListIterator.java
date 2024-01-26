import java.util.Iterator;

public class StaffListIterator implements Iterator<Employee> {

    private final StaffList staffList;
    private int index = 0;

    public StaffListIterator(StaffList staffList) {
        this.staffList = staffList;
    }

    @Override
    public boolean hasNext() {
        return index < staffList.getEmployees().length;
    }

    @Override
    public Employee next() {
        return hasNext() ? staffList.getEmployees()[index++] : null;
    }
}
