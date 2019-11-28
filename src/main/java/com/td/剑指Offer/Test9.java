package com.td.剑指Offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class Test9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push 时间复杂度：O(1)空间复杂度：O(1)
     * 当插入时，直接插入 stack1
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * pop 时间复杂度：O(n)空间复杂度：O(n)
     * 当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
     *
     * @return
     */
    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
