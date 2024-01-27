public class SalesPerson implements Employee {

  private int salary = 50000;

  public void setSalary(int price) {
    this.salary = salary;
  }

  public int getSalary() {
    return salary;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitSalesPerson(this);
  }

}
