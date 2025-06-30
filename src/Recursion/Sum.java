package Recursion;

public class Sum {

    //variable method
    public static int sum1(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    //recursion method
    public static int sum2(int[] arr) {
        return sum(arr, 0);
    }
    private static int sum(int[] arr, int s) {
        if(s == arr.length) {
            return 0;
        }
        return arr[s] + sum(arr, s+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int res1 = sum1(nums);
        int res2 = sum2(nums);
        System.out.println(res1);
        System.out.println(res2);
    }
}
