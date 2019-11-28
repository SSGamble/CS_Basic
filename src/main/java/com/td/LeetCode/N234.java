package com.td.LeetCode;

import org.junit.Test;

/**
 * Created by TravelerTD on 2019/5/19. 请判断一个链表（无哨兵节点）是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1.2 输出: false 示例 2:
 * <p>
 * 输入: 1.2.2.1 输出: true
 * <p>
 * 输入：null 输出：true ----------------- 思路： 1. 快慢指针找中点 2.
 * 将两边等分为前后两个部分，若为奇数则前偶后奇，2-3 3. 反转前半链表 4. 重新更改双指针的指向：一个指针从反转后的前半链表 head
 * 开始，一个指针从后半链表 head 开始，同时向后移动，判断
 */
public class N234 {
    @Test
    public void fun() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
    }

    public static boolean isPalindrome(ListNode head) {
        // 链表为空或链表只有一位，返回 true
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head; // 快指针
        ListNode slow = head; // 慢指针
        ListNode brk = null; // 分割链表，表示前半链表的最后一个节点
        // 确定中点，ps：此为无哨兵节点的情况
        while (fast != null && fast.next != null) {
            brk = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstNode2 = brk.next; // 后半部分链表第一个节点
        brk.next = null; // 拆分链表
        // 反转后半部分链表
        ListNode prev = null;
        ListNode curr = firstNode2;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // 顺序比较两个链表
        // 终止条件只需要前半部列表结尾即可，因为后半部列表长度 >= 前半部
        // 当链表 长度为奇数时，原链表中间元素（即后半部列表翻转后尾元素）忽略
        while (head != null) {
            if (head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
