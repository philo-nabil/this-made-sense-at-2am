## Exception Handling

### Mini concept

An **exception** is a runtime error — something that goes wrong while the program is running. Without handling it, your entire app crashes.

```java
int result = 10 / 0;  // ArithmeticException — app crashes
```

You handle exceptions with `try/catch`:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Can't divide by zero: " + e.getMessage());
}
```

**`finally`** — runs no matter what, even if an exception occurred. Used for cleanup:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("This always runs");
}
```

**Custom exceptions** — you can define your own exception types for your business logic:

```java
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```

Then throw it:
```java
throw new InsufficientFundsException("Balance too low for this withdrawal");
```

Two types of exceptions to know:
- **Checked** — must be handled or declared (e.g. `IOException`). Compiler forces you.
- **Unchecked** — extend `RuntimeException`, no forced handling (e.g. `NullPointerException`). Your custom business exceptions are almost always unchecked.

---

### Exercise

> Go back to your `BankAccount` class. Right now `withdraw()` just prints "Insufficient funds". That's weak — in a real backend, the calling code needs to *know* something went wrong so it can respond properly (return a 400 error, log it, etc.).
>
> 1. Create a custom exception `InsufficientFundsException` that extends `RuntimeException`
> 2. In `withdraw()`, instead of printing, throw this exception with a message that includes the attempted amount and the current balance
> 3. In `main`, call `withdraw()` with insufficient funds inside a `try/catch`, catch your custom exception and print the message
> 4. Add a `finally` block that always prints `"Transaction attempt complete"`

---

### Pro tips

**Never swallow exceptions with an empty catch**
```java
} catch (Exception e) {
    // ← empty, you'll never know something went wrong
}
```
Always at minimum print `e.getMessage()`. In real backends you log it properly.

**Catch the specific exception, not `Exception`**
```java
catch (Exception e)                    // ← too broad, hides bugs
catch (InsufficientFundsException e)   // ← precise, intentional
```

**Custom exceptions are your API's language**
In Spring Boot your controller will catch `InsufficientFundsException` and return a `400 Bad Request` to the client. The exception name itself communicates what went wrong — that's why naming matters.

---

### Deep dive — why this matters in backend

In Spring Boot there's a pattern called `@ControllerAdvice` — a global exception handler that intercepts any exception thrown anywhere in your app and converts it to a proper HTTP response:

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<String> handle(InsufficientFundsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
```

Every custom exception you throw anywhere in your service layer automatically becomes a clean API error response. You'll build this in Phase 03. The habit you're building now — throwing specific custom exceptions instead of printing — is exactly what makes that work.

---

Four topics down, three left in Phase 01 — **Generics**, **Lambdas**, and **Streams**. These three are the ones most Java devs are weak on. Ready?