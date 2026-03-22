## Abstract Classes

### Mini concept

An **abstract class** is a mix between a regular class and an interface. It can have:
- **Abstract methods** — no body, just like interface methods, subclasses *must* implement them
- **Real methods** — actual implementations that subclasses *inherit* for free

```java
abstract class Shape {
    abstract double area();       // must be implemented by subclasses

    void printArea() {            // real method, inherited for free
        System.out.println("Area: " + area());
    }
}
```

You **can't instantiate** an abstract class directly:
```java
Shape s = new Shape();  // ❌ won't compile
```

You extend it:
```java
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
```

---

### Interface vs Abstract class — when to use which

|                                 | Interface              | Abstract class                              |
|---------------------------------|------------------------|---------------------------------------------|
| Has real method implementations | only `default` methods | yes                                         |
| Has fields/state                | no                     | yes                                         |
| A class can use multiple        | yes                    | no (one only)                               |
| Use when                        | defining a contract    | sharing common code between related classes |

The rule of thumb: **interface** = *can do something*. **Abstract class** = *is a type of something*.

A `PayPal` and `CreditCard` both *can* process payments → interface.
A `Dog` and `Cat` both *are* animals with shared behavior → abstract class.

---

### Exercise

> You're building a backend for a food delivery app. Every order item has a name and a base price. But the final price calculation differs:
> - **RegularItem** — final price is just the base price
> - **DiscountedItem** — final price is base price minus a discount amount
> - **TaxedItem** — final price is base price plus 14% tax (Egyptian VAT)
>
> All items must be able to `getFinalPrice()`. All items should also have a `printReceipt()` method that prints `"Item: [name], Price: [finalPrice]"` — this logic is **identical for all**, so it belongs in the abstract class.
>
> 1. Create an abstract class `OrderItem` with `name` and `basePrice` fields, an abstract `getFinalPrice()`, and a real `printReceipt()`
> 2. Create the three subclasses
> 3. In `main`, create one of each, add them to a `List<OrderItem>`, loop and call `printReceipt()` on each