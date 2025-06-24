package losummer;

public class MaxSumSubarray {
    public int maxiSub(int[] nums, int k) {
        if(nums.length < k) {
            return 0;
        }

        int res = 0;
        int subsum = 0;

        for(int left = 0; left < k; left++) {
            subsum += nums[left];
        }
        res = subsum;

        for(int right = k; right < nums.length; right++) {
            subsum += nums[right] - nums[right - k];
            res = Math.max(res, subsum);
        }

        return res;
    }

    public int maxiSub2(int[] nums, int k) {
        if(nums.length < k) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for(int j = i ; j < i+k; j++) {
                sum += nums[j];
            }
            if(res < sum) {
                res = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSumSubarray sub = new MaxSumSubarray();
        MaxSumSubarray sub2 = new MaxSumSubarray();
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int res = sub.maxiSub(nums, k);
        int res2 = sub2.maxiSub2(nums, k);
        System.out.println(res);
        System.out.println(res2);
    }
}

//Method: Sliding Windows
