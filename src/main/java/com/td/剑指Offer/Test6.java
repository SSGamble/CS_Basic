package com.td.剑指Offer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个 ArrayList。
 */
public class Test6 {
//    public class ListNode {
//        int val;
//        ListNode next = null;
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
    public static void main(String[] args) {
        ListNode list = new ListNode(2);
        list.next = new ListNode(3);
        list.next.next = new ListNode(5);
        ArrayList<Integer> al = printListFromTailToHead(list);
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.indexOf(i) + ",");
        }
    }

    // 非递归，时间复杂度：O(n) 空间复杂度：O(n)
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null) {
            list.add(0, tmp.val); // 在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
            tmp = tmp.next;
        }
        return list;
    }

    // 递归，时间复杂度：O(n) 空间复杂度：O(n)
    private static ArrayList<Integer> arrList = new ArrayList();

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrList.add(listNode.val);
        }
        return arrList;
    }
}
