package com.td.剑指Offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Test8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 下一个结点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树的下一个结点
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) { // 1.当前节点有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else { // 2.当前节点无右子树
            while (pNode.next != null) {
                if (pNode.next.left == pNode) { // 2.1 当前节点是父节点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
                    return pNode.next;
                } else { // 2.2 当前节点是父节点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，
                    // 如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。
                    // 例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
                    pNode = pNode.next;
                }
            }
            return null;
        }
    }
}
