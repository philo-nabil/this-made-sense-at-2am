public class BankAccount {
    private String owner_name;
    private double balance;

    public BankAccount(String owner_name, double balance) {
        this.owner_name = owner_name;
        this.balance = balance;
    }

    void deposit(double depositedMoney){
        balance +=depositedMoney;
    }
    void withdraw(double drawMoney){

        if(balance < drawMoney){
            System.out.println("Insufficient Funds");

        }
        else{
            balance-=drawMoney;
        }
    }
}

void main() {
    BankAccount test1 = new BankAccount("philo",1000);
    test1.deposit(1000);
    test1.withdraw(10000);
    test1.withdraw(500);

}
