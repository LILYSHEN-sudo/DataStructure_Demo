package losummer;

import java.util.Arrays;

public class minSubArray {
    //Method-1: Array Sort
    public int minSubArrayLen(int[] nums, int S) {
        Arrays.sort(nums);
        int res = 0;
        int sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(sum < S) {
                sum += nums[i];
                res++;
            }
        }
        if(sum >= S) {
            return res;
        } else {
            return 0;
        }
    }

    //Method-2: SLide window


    public static void main(String[] args) {
        minSubArray min = new minSubArray();
        int[] nums = new int[]{1,2,3,4,5};
        int res = min.minSubArrayLen(nums, 15);
        System.out.println(res);
    }
}
