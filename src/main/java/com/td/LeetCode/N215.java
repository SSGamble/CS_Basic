package com.td.LeetCode;

import org.junit.Test;
import java.util.Arrays;

/**
 * 数组中的第 K 个最大元素
 */
public class N215 {
    @Test
    public void Test() {
        int[] arr = new int[]{6, 7, 1, 5, 3};
        int a = findKthLargest(arr, 3);
        System.out.println(a);

        int b[] = findKthLargest2(arr, 3);
        for (int i : b) {
            System.out.print(i + " ");
        }
    }

    /**
     * 数组中的第 K 个最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 数组取前 K 个最大的
     */
    public int[] findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        int arr[] = new int[k];
        for (int i = nums.length - 1, j = 0; j < k; i--, j++) {
            arr[j] = nums[i];
        }
        return arr;
    }
}
