package com.td.剑指Offer;

/**
 * Created by TravelerTD on 2019/9/3.
 */
public class iTest {
    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 1, 0, 2, 5, 3};
        int length = num.length;
        int[] ref = new int[length];
        duplicate(num, length, ref);
        System.out.println(ref[0]);
    }
}
