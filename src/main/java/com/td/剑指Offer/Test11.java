package com.td.剑指Offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 */
public class Test11 {
    /**
     * 二分查找法 时间复杂度：O(logn) 空间复杂度：O(1)
     *
     * @param array 旋转数组 {3，4，5，1，2}
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] < array[j]) {
                return array[i];
            }
            int mid = (i + j) >> 1; // 等价于 mid=(i+j)/2，但计算机处理位运算要快得多
            if (array[mid] > array[i]) {
                i = mid + 1;
            } else if (array[mid] < array[j]) {
                j = mid; // 如果是 mid-1，则可能会错过最小值，因为找的就是最小值
            } else { // 巧妙避免了 offer 书上说的坑点（1 0 1 1 1）
                i++;
            }
        }
        return array[i];
    }
}
