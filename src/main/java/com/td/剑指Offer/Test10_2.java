package com.td.剑指Offer;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Test10_2 {
    /**
     * 经分析可得公式，和 斐波那契（Fibonacci）数列 类似
     * F(1)=1, F(2)=2, F(n)=F(n-1)+F(n-2) n>2
     * @param n
     * @return
     */
    public int JumpFloor(int n) {
        int sum = 2; // 存储第 n+1 项
        int one = 1; // 存储第 n 项的值
        while (n-- > 1) { // for (int i = 0; i < n; i++)
            sum = one + sum;
            one = sum - one;
        }
        return one;
    }
}
