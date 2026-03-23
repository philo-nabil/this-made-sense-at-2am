package Class_Object_example;

public class BankAccount {
    private final String ownerName;
    private double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient Funds");
        } else {
            balance -= amount;
        }
    }

    public void showBalance() {
        System.out.println("Balance: " + balance);
    }

    @Override
    public String toString() {
        return "BankAccount{ownerName='" + ownerName + "', balance=" + balance + "}";
    }
}
