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
    public int minSubArrayLen2(int[] nums, int S) {
        int res = Integer.MAX_VALUE;
        int subsum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            subsum += nums[right];
            while(subsum >= S) {
                res = Math.min(res, right - left + 1);
                subsum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        minSubArray min = new minSubArray();
        int[] nums = new int[]{2,3,1,2,4,3};
        int res = min.minSubArrayLen(nums, 7);
        int res2 = min.minSubArrayLen2(nums, 7);
        System.out.println(res);
        System.out.println(res2);
    }
}
