package Maximum_Subarray;

import java.util.Arrays;

public class MaxSubarray {
    private int[] nums;
    private int maxSum;
    private int usefulSum;
    private int start;
    private int end;
    public MaxSubarray() {}

    public void reset(int[] nums, int i) {
        maxSum = nums[i]; usefulSum = nums[i]; start = i; end = i;
    }
    public int findMaxSubarray(int[] nums) {
        this.nums = nums;
        this.maxSum = nums[0];
        this.usefulSum = nums[0];
        this.start = 0;
        this.end = 0;

        for(int i = 1; i < nums.length; i++) {
            if (maxSum < 0 && nums[i] >= 0) {
                reset(nums, i);

            } else if (maxSum < 0 && nums[i] < 0 && nums[i] > maxSum) {
                reset(nums, i);

            } else if (maxSum > nums[i]) {

            } else if (usefulSum >= 0) {
                usefulSum += nums[i];

                if (usefulSum > maxSum) {
                    maxSum = usefulSum;
                    end = i;
                }
            } else if (nums[i] > maxSum) {
                    reset(nums, i);
            }
        }
        return maxSum;
    }
    // max = 6
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {5,4,-1,7,8};
        int[] nums3 = {-1,-2};
        int[] nums4 = {1,-2,0};
        int[] nums5 = {8,-19,5,-4,20};
        MaxSubarray maxSub = new MaxSubarray();
//        System.out.println(maxSub.findMaxSubarray(nums));
//        System.out.println(maxSub.findMaxSubarray(nums2));
//        System.out.println(maxSub.findMaxSubarray(nums3));
//        System.out.println(maxSub.findMaxSubarray(nums4));
        System.out.println(maxSub.findMaxSubarray(nums5));
    }
}