package com.td.剑指Offer;

/**
 * 题目一：找出数组中重复的数字。
 * 在一个长度为 n 的数组里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2，3，1，0，2，5，3}，那么对应的输出是重复的数字 2 或者 3。
 * <p>
 * 思路：
 * 我们注意到数组中的数字都在 0~n-1 的范围内。如果这个数组中没有重复的数字，那么当数组排序之后数字 i 将出现在下标为 i 的位置。
 * 如果数组中有重复的数字，那么，有些位置可能存在多个数字，同时有些位置可能没有数字。
 * <p>
 * 遍历数组，如果当前位置与当前数值不相等，就看目标位置是否已有该数值，有，重复，没有，把当前数字放到目标位置
 */
public class Test3 {

    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) { // 边界检查
            return false;
        }
        for (int i = 0; i < length; i++) { // 数组中的数字是否在 0~n-1 的范围内
            if (nums[i] < 0 || nums[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) { // 当前位置与当前数值不相等
                if (nums[i] == nums[nums[i]]) { // 这个数字应该在的位置是否已经存在数字
                    duplication[0] = nums[i]; // 已经存在，重复
                    return true;
                }
                swap(nums, i, nums[i]); // 把当前数字放在应该在的位置，i：当前下标，nums[i]：应该在的下标
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
        int[] num = {2, 3, 1, 0, 2, 5, 9};
        int length = num.length;
        int[] ref = new int[1];
        boolean flag = duplicate(num, length, ref);
        if (flag) {
            System.out.println(ref[0]);
        } else {
            System.out.println("数据有误，或无重复");
        }
    }
}
