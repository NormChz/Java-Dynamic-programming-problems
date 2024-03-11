package LIS;

import java.util.Arrays;

public class LISLength {

    public int findLIS(int[] nums) { // Longest increasing subsequence (numbers)
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for (int i = nums.length - 1; i > -1; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        System.out.println(Arrays.toString(LIS));
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 1, 9, 8, 4, 5, 7, 11, 13};
        LISLength lisLength = new LISLength();
        lisLength.findLIS(arr);
    }
}
