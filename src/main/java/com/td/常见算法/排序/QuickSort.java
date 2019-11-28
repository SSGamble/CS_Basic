package com.td.常见算法.排序;

import org.junit.Test;

/**
 * 快速排序
 */
public class QuickSort {

    @Test
    public void Test() {
        int[] arr = new int[]{6, 7, 1, 5, 3};
        quickSort(arr, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // 快速排序，a 是数组，n 表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r 为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1); // 递归前半段
        quickSortInternally(a, q + 1, r); // 递归后半段
    }

    // 分区函数
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r]; // 选择最后一个元素作为分区点
        int i = p; // 通过游标 i 把 A[p..r] 分成两部分。A[p..i-1] 的元素都是小于 pivot 的，我们暂且叫它“已处理区间”，A[i..r] 是“未处理区间”。
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) { // 如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        // 最后 a[i] 和 a[r] 交换位置，即，将分区点放在他应该在的位置
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
}
