public class VisitorIncreasePayment implements Visitor{
    @Override
    public void visitManager(Manager manager) {
        manager.setSalary(manager.getSalary() - 500);
    }

    @Override
    public void visitSalesPerson(SalesPerson salesPerson) {
        salesPerson.setSalary(salesPerson.getSalary() + 400);
    }
}
