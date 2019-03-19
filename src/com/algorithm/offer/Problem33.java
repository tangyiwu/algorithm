package com.algorithm.offer;

import com.algorithm.model.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的后序遍历序列
 */
public class Problem33 {
    public boolean isPostOrder(TreeNode tree, int[] order) {
        if (tree == null || order == null || order.length <= 0) {
            return false;
        }
        int index = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left == null && top.right == null) {
                stack.pop();
                if (top.val != order[index]) {
                    return false;
                }
                index++;
                continue;
            }
            TreeNode right = top.right;
            TreeNode left = top.left;
            top.left = top.right = null;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        return index == order.length;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node0.left = node1;
        node0.right = node2;
        int[] a = {1, 3, 2};
        int[] b = {1, 2, 3};
        int[] c = {2, 1, 3};
        System.out.println(new Problem33().isPostOrder(node0, a));
        System.out.println(new Problem33().isPostOrder(node0, b));
        System.out.println(new Problem33().isPostOrder(node0, c));
    }
}
