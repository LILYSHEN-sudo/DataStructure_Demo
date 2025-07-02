package Recursion;

public class Fibonacci {
    //iteration
    public long fib1(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        for(int i = 0; i < n-1; i++) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public long fib2(int n) {
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci ans = new Fibonacci();
        System.out.println(ans.fib1(8));
        System.out.println(ans.fib2(8));
    }
}
