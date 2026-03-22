## Classes & Objects — fast refresh

A **class** is a blueprint. An **object** is the real thing built from it.

```java
class Car {
    String brand;
    int speed;

    void accelerate() {
        speed += 10;
    }
}

// Somewhere in main:
Car myCar = new Car();
myCar.brand = "Toyota";
myCar.accelerate();
```

`Car` = blueprint. `myCar` = the actual object living in memory.

You also have a **constructor** — a special method that runs when you create the object:

```java
class Car {
    String brand;
    int speed;

    Car(String brand) {       // constructor
        this.brand = brand;
        this.speed = 0;
    }

    void accelerate() {
        speed += 10;
    }
}

Car myCar = new Car("Toyota");  // constructor called here
```

---

### Exercise

Before we touch interfaces or abstract classes, make sure this is solid:

> Model a `BankAccount`. It should have an owner name and a balance. You should be able to deposit money, withdraw money (but not below zero — just print "Insufficient funds"), and print the current balance.

Write the class and a `main` that creates an account, deposits, withdraws, and prints the balance. Don't overthink it — just get it working.