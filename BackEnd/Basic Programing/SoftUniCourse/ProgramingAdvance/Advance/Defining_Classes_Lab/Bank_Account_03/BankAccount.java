package JavaAdvance.Defining_Classes_Lab.Bank_Account_03;

public class BankAccount {
    private static int id;
    private double balance;
    private static double interestRate = 0.02;

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

}
