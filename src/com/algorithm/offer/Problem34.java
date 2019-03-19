package com.algorithm.offer;

import com.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Problem34 {
    List<List<Integer>> solutions = new ArrayList<>();

    public void findPath(TreeNode tree, int threshold, List<Integer> path) {
        if (tree == null) {
            return;
        }
        path.add(tree.val);
        threshold -= tree.val;
        if (tree.left == null && tree.right == null && threshold == 0) {
            solutions.add(new ArrayList<>(path));
        } else {
            findPath(tree.left, threshold, path);
            findPath(tree.right, threshold, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Problem34 problem34 = new Problem34();
        TreeNode node0 = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        problem34.findPath(node0, 22, new ArrayList<>());
        for (List<Integer> path : problem34.solutions) {
            for (Integer node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
