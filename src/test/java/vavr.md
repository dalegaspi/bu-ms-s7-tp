# The Road to Using vavr with Java

Having functions (finally) as first class citizens and having stream finally brought Java to the modern world, allowing you to do something like this:

```java
public class MyClass {
    int twice(int input) {
        return 2 * i;
    }
    
    public static void main(String[] args) {
        var lst = List.of(1, 2, 3, 4, 5); 
        lst.stream().map()
    }
}
```
