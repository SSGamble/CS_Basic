package com.td.常见算法.回溯;

import org.junit.Test;

/**
 * N 皇后
 */
public class QueenN {
    int count = 0; // 有多少种解
    int N = 4; // N 皇后
    int[] result = new int[N];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列

    @Test
    public void test() {
        calNQueens(0);
        System.out.println(N + " 皇后，共有 " + count + " 种解...");
    }

    /**
     * 一行一行放棋子
     *
     * @param row
     */
    public void calNQueens(int row) { // 调用方式：calNQueens(0);
        if (row == N) { // 8 个棋子都放置好了，打印结果
            printQueens(result);
            count++;
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int column = 0; column < N; ++column) { // 每一行都有 8 种放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第 row 行的棋子放到了 column 列
                calNQueens(row + 1); // 考察下一行
            }
        }
    }

    /**
     * 判断 row 行 column 列放置是否合适
     *
     * @param row    行
     * @param column 列
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1; // 左上对角线，偏移
        int rightUp = column + 1; // 右上对角线，偏移
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第 i 行的 column 列有棋子吗？
            if (leftUp >= 0) { // 考察左上对角线：第 i 行 leftUp 列有棋子吗？
                if (result[i] == leftUp) return false;
            }
            if (rightUp < N) { // 考察右上对角线：第 i 行 rightUp 列有棋子吗？
                if (result[i] == rightUp) return false;
            }
            --leftUp; // 左上对角线偏移
            ++rightUp; // 右上对角线偏移
        }
        return true;
    }

    /**
     * 打印出一个二维矩阵
     */
    private void printQueens(int[] result) {
        for (int row = 0; row < N; ++row) {
            for (int column = 0; column < N; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
