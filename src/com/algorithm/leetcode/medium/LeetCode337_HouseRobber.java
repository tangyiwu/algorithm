package com.algorithm.leetcode.medium;

import com.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode337_HouseRobber {
    public static void main(String[] args) {
    }

    private Map<TreeNode, Integer> robWithRoot = new HashMap<>();
    private Map<TreeNode, Integer> robWithoutRoot = new HashMap<>();

    public int rob(TreeNode root) {
        dnf(root);
        return Math.max(robWithRoot.getOrDefault(root, 0), robWithoutRoot.getOrDefault(root, 0));
    }

    public void dnf(TreeNode root) {
        if (root == null) {
            return;
        }
        dnf(root.left);
        dnf(root.right);
        robWithRoot.put(root, root.val + robWithoutRoot.getOrDefault(root.left, 0) + robWithoutRoot.getOrDefault(root.right, 0));
        robWithoutRoot.put(root, Math.max(robWithRoot.getOrDefault(root.left, 0), robWithoutRoot.getOrDefault(root.left, 0))
                + Math.max(robWithRoot.getOrDefault(root.right, 0), robWithoutRoot.getOrDefault(root.right, 0)));
    }


}
