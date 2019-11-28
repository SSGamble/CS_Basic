package com.td.LeetCode;

/**
 * -----------------
 * 思路和算法
 * 当用慢指针 slow 遍历列表时，让另一个指针 fast 的速度是它的两倍。
 * 当 fast 到达列表的末尾时，slow 必然位于中间。
 * -----------------
 * 复杂度分析
 * 时间复杂度：O(N)，其中 N 是给定列表的结点数目。
 * 空间复杂度：O(1)，slow 和 fast 用去的空间。
 */
public class N876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
