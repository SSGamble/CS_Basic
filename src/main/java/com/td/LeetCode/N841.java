package com.td.LeetCode;

import java.util.List;
import java.util.Stack;

/**
 * 钥匙和房间
 * Created by TravelerTD on 2019/9/9.
 */
public class N841 {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] isOpenArr = new boolean[rooms.size()]; // 房间是否被打开
            isOpenArr[0] = true; // 默认 0 号房间打开
            Stack<Integer> stack = new Stack(); // 未被使用的钥匙，待办清单
            stack.push(0); // 默认 0 号还没开始使用

            while (!stack.isEmpty()) { // 只要我们手上还有钥匙，就一直尝试
                int key = stack.pop(); // 获取一把钥匙
                for (int i : rooms.get(key)) { // 遍历该房间拥有的钥匙
                    if (!isOpenArr[i]) { // 如果钥匙对应的房间没有被打开
                        isOpenArr[i] = true; // 打开对应的房间
                        stack.push(i); // 从待办钥匙中移除
                    }
                }
            }
            // 如果有房间没有被打开，返回 false
            for (boolean isOpen : isOpenArr) {
                if (!isOpen) {
                    return false;
                }
            }
            // 房间全部都打开了
            return true;
        }
    }
}
