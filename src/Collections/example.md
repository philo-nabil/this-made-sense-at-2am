## Collections

### Mini concept

Collections are containers for groups of objects. Three you need to know cold:

**`List`** — ordered, allows duplicates, access by index
```java
List<String> names = new ArrayList<>();
names.add("Philo");
names.add("John");
names.get(0);  // "Philo"
```

**`Set`** — no duplicates, no guaranteed order
```java
Set<String> names = new HashSet<>();
names.add("Philo");
names.add("Philo");  // ignored, already exists
names.size();  // 1
```

**`Map`** — key/value pairs, like a dictionary
```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Philo", 95);
scores.put("John", 87);
scores.get("Philo");  // 95
```

---

### When to use which

|        | Use when                               |
|--------|----------------------------------------|
| `List` | Order matters, or you need duplicates  |
| `Set`  | You need unique values only            |
| `Map`  | You need to look something up by a key |

---

### Exercise

> You're building a backend for a small online store. You have orders coming in and you need to:
>
> 1. Keep a `List<String>` of incoming orders in the order they arrived — add: `"Order#1-Laptop"`, `"Order#2-Phone"`, `"Order#3-Laptop"`, `"Order#4-Tablet"`. Print the full list.
>
> 2. From that list, build a `Set<String>` of **unique product names only** (just the product part, not the order number — `"Laptop"`, `"Phone"`, `"Tablet"`). Print the set.
>
> 3. Build a `Map<String, Integer>` that tracks **how many times each product was ordered**. Print each product and its count.

All three in one `main`. The map part requires a bit of thinking — figure out how to count occurrences.

---
### Pro tips

**`getOrDefault()`** — a cleaner way to write the count logic:
```java
scores.put(parts[1], scores.getOrDefault(parts[1], 0) + 1);
```
Gets the current value, or 0 if it doesn't exist yet. Replaces the entire `if/else`. You'll see this pattern constantly in backend code.

**`Map` iteration** — when you need to print key/value pairs properly:
```java
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + " ordered " + entry.getValue() + " times");
}
```

---

### Deep dive — why these three matter for backend

In Spring Boot you'll use these everywhere:
- **`List`** — returning a list of users, orders, products from your API
- **`Set`** — storing roles/permissions for a user (`ROLE_ADMIN`, `ROLE_USER`) — duplicates make no sense there
- **`Map`** — caching, grouping results, building response objects dynamically

The `Map` counting pattern you just wrote is also the foundation of a lot of analytics logic — counting events, grouping by category, building histograms.

---

Three topics down. Next is **Exception Handling**. Ready?