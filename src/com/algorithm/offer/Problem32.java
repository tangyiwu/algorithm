package com.algorithm.offer;

import com.algorithm.model.TreeNode;

import java.util.*;

/**
 * 从上往下打印二叉树
 */
public class Problem32 {
    public void printSingleLine(TreeNode tree) {
        if (tree == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeLast();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.addFirst(node.left);
            }
            if (node.right != null) {
                queue.addFirst(node.right);
            }
        }
    }

    public void printMultiLine(TreeNode tree) {
        if (tree == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int level = 0;
        queue.add(tree);
        map.put(tree, level);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeLast();
            if (map.get(node) > level) {
                level = map.get(node);
                System.out.println();
            }
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.addFirst(node.left);
                map.put(node.left, level + 1);
            }
            if (node.right != null) {
                queue.addFirst(node.right);
                map.put(node.right, level + 1);
            }
        }
    }

    public void printZLine(TreeNode tree) {
        if (tree == null) {
            return;
        }
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        List<TreeNode> levelNodes = new ArrayList<>();
        queue.addFirst(tree);
        map.put(tree, level);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeLast();
            if (map.get(node) > level) {
                level = map.get(node);
                printOneLevelNodes(levelNodes, level % 2 == 1);
                levelNodes.clear();
            }
            levelNodes.add(node);
            if (node.left != null) {
                queue.addFirst(node.left);
                map.put(node.left, level + 1);
            }
            if (node.right != null) {
                queue.addFirst(node.right);
                map.put(node.right, level + 1);
            }
        }
        if (!levelNodes.isEmpty()) {
            printOneLevelNodes(levelNodes, map.get(levelNodes.get(0)) % 2 == 0);
        }
    }

    private void printOneLevelNodes(List<TreeNode> nodes, boolean fromLeft) {
        if (fromLeft) {
            for (TreeNode node : nodes) {
                System.out.print(node.val + " ");
            }
        } else {
            for (int i = nodes.size() - 1; i >= 0; i--) {
                System.out.print(nodes.get(i).val + " ");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Problem32 problem32 = new Problem32();
        problem32.printSingleLine(node1);
        System.out.println();
        problem32.printMultiLine(node1);
        System.out.println();
        problem32.printZLine(node1);
    }
}
