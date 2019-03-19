package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

public class LeetCode108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l + 1) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = createTree(nums, l, m - 1);
        root.right = createTree(nums, m + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = new LeetCode108_SortedArrayToBST().sortedArrayToBST(nums);
    }
}
