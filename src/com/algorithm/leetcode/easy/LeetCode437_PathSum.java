package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode437_PathSum {
    int cnt = 0;
    Set<TreeNode> startRoots = new HashSet<>();

    public int pathSum(TreeNode root, int sum) {
        cnt = 0;
        startRoots.add(root);
        search(root, sum, 0);
        return cnt;
    }

    private void search(TreeNode root, int sum, int added) {
        if (root == null) {
            return;
        }
        if (root.val + added == sum) {
            cnt++;
        }
        search(root.left, sum, added + root.val);
        search(root.right, sum, added + root.val);
        if (!startRoots.contains(root.left)) {
            startRoots.add(root.left);
            search(root.left, sum, 0);
        }
        if (!startRoots.contains(root.right)) {
            startRoots.add(root.right);
            search(root.right, sum, 0);
        }
    }

    public static void main(String[] args) {
        /**
         * [1,-2,-3,1,3,-2,null,-1]
         * 3
         */
        TreeNode root = new TreeNode(1);
        TreeNode levelTwo1 = new TreeNode(-2);
        TreeNode levelTwo2 = new TreeNode(-3);
        TreeNode levelThree1 = new TreeNode(1);
        TreeNode levelThree2 = new TreeNode(3);
        TreeNode levelThree3 = new TreeNode(-2);
        TreeNode levelFour1 = new TreeNode(-1);
        root.left = levelTwo1;
        root.right = levelTwo2;
        levelTwo1.left = levelThree1;
        levelTwo1.right = levelThree2;
        levelTwo2.left = levelThree3;
        levelThree1.left = levelFour1;
        LeetCode437_PathSum pathSum = new LeetCode437_PathSum();
        System.out.println(pathSum.pathSum(root, 3));
    }
}
