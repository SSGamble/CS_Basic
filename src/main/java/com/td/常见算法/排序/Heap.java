package com.td.常见算法.排序;

/**
 * 堆
 */
public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1]; // 因为是从 1 开始存储
        n = capacity;
        count = 0;
    }

    // 插入
    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化，和父节点进行比较
            swap(a, i, i / 2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            i = i / 2;
        }
    }

    // 删除堆顶元素
    public int removeMax() {
        if (count == 0)
            return -1; // 堆中没有数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
        return 1;
    }

    // 从上往下堆化
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i; // 从堆顶开始
            if (i * 2 <= n && a[i] < a[i * 2]) // 左子节点存在，该节点<左子节点
                maxPos = i * 2; // 记录下标，之后和左子节点交换
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) // 右子节点存在，该节点<右子节点
                maxPos = i * 2 + 1; // 记录下标，之后和右子节点交换
            if (maxPos == i)
                break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    // 建堆
    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i); // 从上往下堆化
        }
    }

    /**
     * 堆排序，n
     *
     * @param a 数组 a 中的数据从下标 1 到 n 的位置
     * @param n 表示数据的个数
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n); // 建堆
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    private void swap(int[] a, int i, int k) { }

}
