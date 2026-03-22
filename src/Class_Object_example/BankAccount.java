public static class BankAccount {
    private final String ownerName;
    private double balance;

    public String getOwnerName() {
        return ownerName;
    }
    public BankAccount(String owner_name, double balance) {
        this.ownerName = owner_name;
        this.balance = balance;
    }

    void deposit(double amount){
        balance += amount;
    }
    void withdraw(double amount){

        if(balance < amount){
            System.out.println("Insufficient Funds");

        }
        else{
            balance-= amount;
        }
    }
    void showBalance(){
        System.out.println("Balance" + balance);
    }
}

void main() {
    BankAccount test1 = new BankAccount("philo", 1000);
    test1.deposit(1000);
    test1.withdraw(10000);
    test1.deposit(200);
    test1.withdraw(500);

}
