package practice.numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    static Map<Integer, Integer> fibonacciMap = new HashMap<>();
    public static int fibonacci(int n) {
        // Complete the function.
        if(fibonacciMap.containsKey(n)) {
            System.out.println("Got "+ n + "th element from cache");
            return fibonacciMap.get(n);
        }
        if(n==0 || n==1) {
            fibonacciMap.put(n, n);
            return n;
        }
        int nthElement = fibonacci(n-1) + fibonacci(n-2);
        fibonacciMap.put(n, nthElement);
        return nthElement;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}