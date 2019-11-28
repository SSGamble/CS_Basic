package com.td.LeetCode;

public class N21 {
    /**
     * 迭代法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1); // 设定一个哨兵节点 "preHead" ，作为合并后链表的头结点
        ListNode prev = preHead; // 遍历指针
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1; // 排序后的指针链
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 在循环终止的时候， l1 和 l2 至多有一个是非空的。
        // 由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
        // 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表。
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * 递归法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

