package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104_MaxBinaryTreeDepth {
    int maxDepth;

    public int maxDepth(TreeNode root) {
        depth(root, 1);
        return maxDepth;
    }

    private void depth(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, curDepth);
        depth(root.left, curDepth + 1);
        depth(root.right, curDepth + 1);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.remove();
                size--;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            cnt++;

        }
        return cnt;
    }
}
