package com.algorithm.leetcode.medium;

import com.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        search(root, list, new ArrayList<>(), sum);
        return list;
    }

    private void search(TreeNode root, List<List<Integer>> list, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            path.add(root.val);
            list.add(path);
            return;
        }
        if (root.left != null) {
            List<Integer> leftPath = new ArrayList<>();
            leftPath.addAll(path);
            leftPath.add(root.val);
            search(root.left, list, leftPath, sum - root.val);
        }
        if (root.right != null) {
            List<Integer> rightPath = new ArrayList<>();
            rightPath.addAll(path);
            rightPath.add(root.val);
            search(root.right, list, rightPath, sum - root.val);
        }
    }
}
