package Recursion;

public class Power {
    //Recursion-1
    public long pow1(int a, int b) {
        if(b < 0) {
            return -1;
        }
        if(b == 0) {
            return 1;
        }
        return a * pow1(a, b-1);
    }

    //Recursion-2
    public long pow2(int a, int b) {
        if(b < 0) {
            return -1;
        }
        if(b == 0) {
            return 1;
        }
        if(b % 2 == 1) {
            return pow2(a, b/2) * pow2(a, b/2) * a;
        } else {
            return pow2(a, b/2) * pow2(a, b/2);
        }
    }

    //For loop
    public long pow3(int a, int b) {
        if(b < 0) {
            return -1;
        }
        if(b == 0 ) {
            return 1;
        }

        long res = 1;
        for(int i = 0; i < b; i++) {
            res = a * res;
        }
        return res;
    }


    public static void main(String[] args) {
        Power ans = new Power();
        int a = 0;
        int b = 4;
        System.out.println(ans.pow1(a, b));
        System.out.println(ans.pow2(a, b));
        System.out.println(ans.pow3(a, b));
    }
}
