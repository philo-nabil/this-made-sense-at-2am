package Generics;
import Class_Object_example.BankAccount;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("philo",1000);
        ApiResponse<BankAccount> response1 = ApiResponse.success(account,"account fetched");
        response1.print();

        ApiResponse<String> response2 = ApiResponse.error("Account not found");
        response2.print();

    }
}
