package com.td.常见算法;

import org.junit.Test;

/**
 * 全排列递归算法
 */
public class FullPermutation {
    @Test
    public void Test() {
        char[] arr = {'a', 'b', 'b'};
        perm(arr, 0, arr.length - 1);
    }

    /**
     * 全排列递归
     *
     * @param k 确定第几位
     * @param n 最后一位字符的下标，即，长度 -1
     */
    private void perm(char[] arr, int k, int n) {
        if (k == n) { // 前缀是最后一个位置（已处理到了最后一个字符）,此时打印排列数
            System.out.println(arr);
        } else {
            for (int i = k; i <= n; i++) { // 第 k 个数分别与它后面的数字交换就能得到新的排列
                if (isSwap(arr, k, i)) { // 判断从字符串开始到现在是否有重复的字符串
                    swap(arr[k], arr[i]); // 交换前缀,使之产生下一个前缀.
                    perm(arr, k + 1, n); // 递归后面的字母全排列
                    swap(arr[k], arr[i]); // 将前缀换回来,继续做上一个的前缀排列.
                }
            }
        }
    }

    // 是否重复
    private boolean isSwap(char[] arr, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (arr[i] == arr[end])
                return false;
        }
        return true;
    }

    private void swap(char c, char c1) {
    }
}
