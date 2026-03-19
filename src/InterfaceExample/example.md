
## Interfaces

### Mini concept

An **interface** is a contract. It says *"any class that signs this contract must provide these methods."* It doesn't care *how* — just that they exist.

```java
interface Printable {
    void print();  // no body — just the contract
}

class Invoice implements Printable {
    public void print() {
        System.out.println("Printing invoice...");
    }
}
```

The power shows up when you have **multiple classes that share behavior but aren't the same thing.** A `PayPal` and a `CreditCard` are completely different objects — but both can `processPayment()`. You define that shared contract in an interface.

```java
interface PaymentMethod {
    void processPayment(double amount);
    void refund(double amount);
}

class PayPal implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("PayPal: processing " + amount);
    }
    public void refund(double amount) {
        System.out.println("PayPal: refunding " + amount);
    }
}

class CreditCard implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("CreditCard: processing " + amount);
    }
    public void refund(double amount) {
        System.out.println("CreditCard: refunding " + amount);
    }
}
```

Now the real payoff — **you can write code that works with any payment method without knowing which one it is:**

```java
void checkout(PaymentMethod method, double amount) {
    method.processPayment(amount);  // works for PayPal, CreditCard, anything
}
```

This is huge in backend. Your `checkout` service doesn't care if the user pays with PayPal or card — it just calls the contract.

---

### Exercise

> You're building a notification system. The app needs to send notifications via **Email** and **SMS**. Both must be able to `send(String message)` and `getDeliveryStatus()` which returns a String.
>
> 1. Create a `Notification` interface with those two methods
> 2. Create `EmailNotification` and `SmsNotification` that implement it
> 3. In `main`, create a list of notifications, add one of each type, loop through and send them all with the message `"Your order has shipped"`
> 4. Print the delivery status of each after sending

The loop in point 3 is the important part — write it so it works with the interface type, not the concrete class.