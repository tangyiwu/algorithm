package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            searchPath(paths, "", root);
        }
        return paths;
    }

    private void searchPath(List<String> paths, String prePath, TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        if (curNode.left == null && curNode.right == null) {
            paths.add(prePath + curNode.val);
            return;
        }
        if (curNode.left != null) {
            searchPath(paths, prePath + curNode.val + "->", curNode.left);
        }
        if (curNode.right != null) {
            searchPath(paths, prePath + curNode.val + "->", curNode.right);
        }
    }
}
