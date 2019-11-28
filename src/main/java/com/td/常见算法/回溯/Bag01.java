package com.td.常见算法.回溯;

import org.junit.Test;

/**
 * 0-1 背包，回溯算法实现
 */
public class Bag01 {

    @Test
    public void test() {
        bag01(0, 0);
        System.out.println("最终背包重量：" + weight);
    }

    private int weight = Integer.MIN_VALUE; // 结果放到 weight 中
    private int[] items = {2, 2, 4, 6, 3};  // 表示每个物品的重量
    private int count = items.length; // 物品个数
    private int bagMaxWeight = 9; // 背包可以承受的最大重量

    /**
     * 0-1 背包
     * @param i 表示考察到哪个物品了
     * @param cw 表示当前已经装进去的物品的重量
     */
    public void bag01(int i, int cw) {
        if (cw == bagMaxWeight || i == count) { // cw == bagMaxWeight 表示装满了；i == count 表示已经考察完所有的物品
            if (cw > weight){
                weight = cw;
            }
            return;
        }
        bag01(i + 1, cw); // 选择不装第 i 个物品
        if (cw + items[i] <= bagMaxWeight) { // 已经超过可以背包承受的重量的时候，就不要再装了
            bag01(i + 1, cw + items[i]); // 选择装第 i 个物品
        }
    }
}
