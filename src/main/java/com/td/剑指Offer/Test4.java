package com.td.剑指Offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test4 {
    /**
     * 由于矩阵从上到下递增，从左到右递增。
     * 总是和二维矩阵的右上角元素比较（对称地，左下角也可以）
     * 如果目标比右上角的大，删除该行，行指针向下移动；如果比右上角的小，删除该列，列指针左移
     * 1   2   8   9
     * 2   4   9  12
     * 4   7  10  13
     * 6   8  11  15
     */
    public static boolean find(int target, int[][] array) {
        if (array != null && array.length > 0) {
            int N = array.length; // 总行数
            int col = array[0].length - 1; // 列索引，最后一列
            int row = 0; // 行索引
            // array[row][col]是右上角的元素
            while (row < N && col >= 0) {
                if (target < array[row][col]) {
                    col--; // 删除该列
                } else if (target > array[row][col]) {
                    row++; // 删除该行
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(find(2,nums));
    }
}
