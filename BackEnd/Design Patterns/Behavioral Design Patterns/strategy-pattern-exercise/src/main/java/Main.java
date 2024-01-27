public class Main {

  public static void main(String[] args) {
    Customer customer = new Customer();
    customer.makePayments(Payment.makeBankAccountPayment , 100);
  }

}
