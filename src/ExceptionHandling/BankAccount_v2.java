import ExceptionHandling.InsufficientFundsException;

public static class BankAccount {
    private final String ownerName;
    private double balance;


    public BankAccount(String owner_name, double balance) {
        this.ownerName = owner_name;
        this.balance = balance;
    }

    void deposit(double amount){
        balance += amount;
    }
    void withdraw(double amount){

        if(balance < amount){
            throw new InsufficientFundsException(
                    "Insufficient funds — attempted: " + amount + ", available: " + balance
            );


        }
        else{
            balance-= amount;
        }
    }
    void showBalance(){
        System.out.println("Balance" + balance);
    }

    public String getOwnerName() {
        return ownerName;
    }
}

void main() {
    BankAccount test1 = new BankAccount("philo", 1000);
    test1.deposit(100000);

    test1.deposit(200);

    try {
        test1.withdraw(1000000);
    } catch (InsufficientFundsException e) {
        System.out.println(e.getMessage());

    } finally {
        System.out.println("Transaction attempt complete");
    }

}
