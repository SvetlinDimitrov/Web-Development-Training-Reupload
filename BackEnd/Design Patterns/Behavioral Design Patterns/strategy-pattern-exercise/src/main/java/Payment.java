public interface Payment {

    void pay(int amount);

    Payment makeBankAccountPayment = (int amount) -> System.out.println("Payment of $ " + amount + " made from bank account.");
    Payment makePayPalPayment = (int amount) -> System.out.println("Payment of $" + amount + " made from PayPal.");
}
