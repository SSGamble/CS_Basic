package com.td.剑指Offer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Test7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 重建二叉树,时间复杂度：O(n) 空间复杂度：O(n)
     * @param pre 前序序列 {1, 2,4,7, 3,5,6,8}
     * @param in  中序序列 {4,7,2, 1, 5,3,8,6}
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]); // 根据当前 前序序列 的第一个结点确定根结点，为 1
        // 在中序中找到前序的根，找到 1 在中序遍历序列中的位置，为 in[3]
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) { // 切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
                // 左子树，注意 copyOfRange 函数，左闭右开，切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开,切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
