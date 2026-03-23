
## Generics — Full Explanation

### The problem generics solve

Imagine you want a box that holds one item. You write:

```java
class Box {
    private Object value;

    public Box(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
```

`Object` works because every class in Java extends `Object`. So this box can hold anything:

```java
Box box1 = new Box("Hello");
Box box2 = new Box(123);
```

Looks fine. But now when you get the value out, Java only knows it's an `Object` — you have to cast it manually:

```java
String name = (String) box1.getValue();  // you're telling Java "trust me, it's a String"
String oops = (String) box2.getValue();  // compiles fine, crashes at runtime — it's an Integer
```

The compiler can't catch that bug. It only blows up when the app is already running. In a backend serving thousands of users, that's a disaster.

---

### How generics fix this

Instead of `Object`, you use a **type parameter** — a placeholder that gets replaced with a real type when you use the class:

```java
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

`T` is just a name — a placeholder. You could write `X` or `Banana` and it would work the same. Convention is `T` for Type, `E` for Element, `K`/`V` for Key/Value.

Now when you create a Box, you tell Java what `T` actually is:

```java
Box<String> box1 = new Box<>("Hello");
Box<Integer> box2 = new Box<>(123);

String name = box1.getValue();  // no cast needed, Java knows it's a String
String oops = box2.getValue();  // ❌ compiler error immediately — caught before runtime
```

The bug is caught at compile time, not when your app is running in production.

---

### T is replaced at compile time

This is the key mental model. When you write:

```java
Box<String> box = new Box<>("Hello");
```

Java reads your `Box<T>` class and mentally replaces every `T` with `String`:

```java
class Box {
    private String value;        // T → String
    public Box(String value) { this.value = value; }
    public String getValue() { return value; }
}
```

When you write `Box<Integer>`, it replaces `T` with `Integer`. Same class, different behavior, zero duplication.

---

### Bounded types — restricting what T can be

Sometimes you want generics, but you need to call methods on `T`. Problem — if `T` can be anything, Java doesn't know what methods it has.

```java
class Calculator<T> {
    public double doubleIt(T value) {
        return value.doubleValue() * 2;  // ❌ Java doesn't know T has doubleValue()
    }
}
```

You fix it by **bounding** T — telling Java it must be a `Number` or subclass:

```java
class Calculator<T extends Number> {
    public double doubleIt(T value) {
        return value.doubleValue() * 2;  // ✅ Number has doubleValue()
    }
}

Calculator<Integer> c = new Calculator<>();
c.doubleIt(5);     // 10.0

Calculator<Double> d = new Calculator<>();
d.doubleIt(3.5);   // 7.0

Calculator<String> s = new Calculator<>();  // ❌ String doesn't extend Number
```

---

### Wildcards — when you don't care what T is

Sometimes you want to accept any generic type without specifying it:

```java
// This only accepts List<String>
void printList(List<String> list) { ... }

// This accepts List<String>, List<Integer>, List<Anything>
void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

`?` means "I don't care what's in this list, I just want to loop through it."

---

### Why this matters for backend

In Spring Boot you'll constantly see generics:

```java
// Returns a list of any type from the database
List<User> users = userRepository.findAll();
List<Order> orders = orderRepository.findAll();

// HTTP response that wraps any type
ResponseEntity<User> response = ResponseEntity.ok(user);
ResponseEntity<List<Order>> response = ResponseEntity.ok(orders);
```

`ResponseEntity<T>` is exactly the `ApiResponse<T>` you're about to build — Spring Boot's built-in version of it.

---

Now try the exercise again with this in mind. The `ApiResponse<T>` class is a real pattern used in production backends — every API endpoint returns a consistent wrapper so the frontend always knows what to expect.

### Exercise

You're building a generic API response wrapper — something every real backend uses. Every endpoint returns either data or an error, wrapped in a consistent structure.

**1. Create a generic class `ApiResponse<T>` with:**
- `boolean success`
- `String message`
- `T data` — the actual payload, could be anything
- A constructor and a `print()` method that prints all three fields

**2. Create two static helper methods inside `ApiResponse`:**
- `success(T data, String message)` — returns an `ApiResponse` with `success=true`
- `error(String message)` — returns an `ApiResponse` with `success=false` and `data=null`

**3. In `main`, simulate two API responses:**
- A successful response where `T` is a `BankAccount`
- An error response where `T` is `String`
- Print both