package com.td.剑指Offer;

/**
 * 写一个函数，输入 n，求斐波那契（Fibonacci）数列的第 n 项。n<=39
 * F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=1，n∈N*）
 */
public class Test10_1 {

    /**
     * 优化，避免递归造成的调用栈消耗。 时间复杂度：O(n) 空间复杂度：O(1)
     * 递归会重复计算大量相同数据，每次就用到了最近的两个数，所以我们可以只存储最近的两个数
     * n = 5 4 3 2 1 0 -1
     * sum 1 1 2 3 5
     * one 0 1 1 2 3
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        int sum = 1; // 存储第 n+1 项
        int one = 0; // 存储第 n 项的值
        while (n-- > 0) { // for (int i = 0; i < n; i++)
            sum = one + sum;
            one = sum - one;
        }
        return one;
    }

    /**
     * 递归
     * 时间复杂度：O(2^n) 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
