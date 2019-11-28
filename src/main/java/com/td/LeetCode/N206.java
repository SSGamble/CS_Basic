package com.td.LeetCode;

/**
 * 反转一个单链表
 */
public class N206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 反转后的头节点，后移遍历，始终表示最新插入的节点
        ListNode curr = head; // 当前节点，后移遍历，始终表示未处理的首节点
        ListNode temp = null; // 临时节点，用于交换操作的中间变量
        while (curr != null) {
            temp = curr.next; // 临时记录，用于之后交换
            curr.next = prev; // 反转，将当前节点指向前一个节点
            prev = curr; // 后移，遍历
            curr = temp; // 交换
        }
        return prev;
    }
}
