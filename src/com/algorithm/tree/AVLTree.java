package com.algorithm.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 平衡二叉树
 */
public class AVLTree {
    private static class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;
        int height;
    }

    public <T> Node<T> insert(Node<T> tree, T newData, Comparator<T> comparator) {
        if (tree == null) {
            tree = createNode(newData);
        } else if (comparator.compare(tree.data, newData) < 0) {
            tree.right = insert(tree.right, newData, comparator);
            // 插入节点后，若AVL树树去平衡，则进行相应的调节
            if (height(tree.right) - height(tree.left) == 2) {
                if (comparator.compare(newData, tree.right.data) > 0) {
                    tree = rightRightRotation(tree);
                } else {
                    tree = rightLeftRotation(tree);
                }
            }
        } else if (comparator.compare(tree.data, newData) > 0) {
            tree.left = insert(tree.left, newData, comparator);
            if (height(tree.left) - height(tree.right) == 2) {
                if (comparator.compare(newData, tree.left.data) < 0) {
                    tree = leftLeftRotation(tree);
                } else {
                    tree = leftRightRotation(tree);
                }
            }
        } else {
            throw new IllegalArgumentException("can not insert same node");
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    private <T> Node<T> createNode(T newData) {
        Node<T> node = new Node<>();
        node.data = newData;
        node.height = 0;
        return node;
    }

    private <T> int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private <T> Node<T> leftLeftRotation(Node<T> tree) {
        if (tree == null) {
            return null;
        }
        Node<T> k1 = tree.left;
        Node<T> k2 = tree;
        k2.left = null;
        Node<T> y = k1.right;
        k1.right = null;
        k2.left = y;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private <T> Node<T> rightRightRotation(Node<T> tree) {
        if (tree == null) {
            return null;
        }
        Node<T> k1 = tree;
        Node<T> k2 = tree.right;
        Node<T> x = k1.left;
        Node<T> y = k2.left;

        k1.right = null;
        k2.left = null;

        k1.right = y;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }

    private <T> Node<T> leftRightRotation(Node<T> tree) {
        if (tree == null) {
            return null;
        }
        tree.left = rightRightRotation(tree.left);
        return leftLeftRotation(tree);
    }

    private <T> Node<T> rightLeftRotation(Node<T> tree) {
        if (tree == null) {
            return null;
        }
        tree.right = leftLeftRotation(tree.right);
        return rightRightRotation(tree);
    }

    /**
     * 先序遍历
     */
    public <T> void preOrder(Node<T> tree) {
        if (tree != null) {
            System.out.print(tree.data + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 非递归先序遍历
     */
    public <T> void preOrderByStack(Node<T> tree) {
        Stack<Node<T>> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                System.out.print(tree.data + " ");
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                tree = tree.right;
            }
        }
    }

    /**
     * 中序遍历
     */
    public <T> void inOrder(Node<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.data + " ");
            inOrder(tree.right);
        }
    }

    /**
     * 非递归中序遍历
     */
    public <T> void inOrderByStack(Node<T> tree) {
        Stack<Node<T>> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.print(tree.data + " ");
                tree = tree.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public <T> void postOrder(Node<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.data + " ");
        }
    }

    /**
     * 非递归后序遍历
     * hard
     * 思路：
     * 要保证根结点在其左孩子和右孩子访问之后才能访问,因此对于任一结点p,先将其入栈.
     * 如果p不存在左孩子和右孩子,则可直接访问;否则将p的右孩子和左孩子依次入栈然后把p的左右孩子结点赋值null,这样就保证了每次取栈顶的元素的时候
     * 左孩子在右孩子前面被访问, 左孩子和右孩子都在根结点前面被访问
     */
    public <T> void postOrderByStack(Node<T> tree) {
        Stack<Node<T>> stack = new Stack<>();
        if (tree != null) {
            stack.push(tree);
            while (!stack.isEmpty()) {
                Node<T> top = stack.peek();
                if (top.left == null && top.right == null) {
                    stack.pop();
                    System.out.print(top.data + " ");
                } else {
                    if (top.right != null) {
                        stack.push(top.right);
                        top.right = null;
                    }
                    if (top.left != null) {
                        stack.push(top.left);
                        top.left = null;
                    }
                }
            }
        }
    }

    /**
     * 层级遍历
     */
    public <T> void levelTraveral(Node<T> tree) {
        if (tree == null) {
            return;
        }
        LinkedList<Node<T>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node<T> cur = queue.removeLast();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(0, cur.left);
            }
            if (cur.right != null) {
                queue.add(0, cur.right);
            }
        }
    }

    public <T> void describe(Node<T> tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            System.out.println(tree.data + "的左孩子是" + tree.left.data);
        }
        if (tree.right != null) {
            System.out.println(tree.data + "的右孩子是" + tree.right.data);
        }
        describe(tree.left);
        describe(tree.right);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        Node<Integer> root = null;
        int[] array = {5, 1, 2, 3, 4, 6, 7, 8, 9, 10};
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        for (int e : array) {
            root = avlTree.insert(root, e, comparator);
        }
        System.out.println("平衡二叉树的高度是" + root.height);
        /**
         * 4的左孩子是2
         * 4的右孩子是8
         * 2的左孩子是1
         * 2的右孩子是3
         * 8的左孩子是6
         * 8的右孩子是9
         * 6的左孩子是5
         * 6的右孩子是7
         * 9的右孩子是10
         */
        //          4
        //       2      8
        //     1  3    6   9
        //            5 7    10
        //
        avlTree.describe(root);
        System.out.println("\n层级遍历:");
        avlTree.levelTraveral(root);
        System.out.println("\n先序遍历:");
        avlTree.preOrder(root);
        System.out.println("\n非递归先序遍历:");
        avlTree.preOrderByStack(root);
        System.out.println("\n中序遍历:");
        avlTree.inOrder(root);
        System.out.println("\n非递归先序遍历:");
        avlTree.inOrderByStack(root);
        System.out.println("\n后序遍历:");
        avlTree.postOrder(root);
        System.out.println("\n非递归后序遍历:");
        avlTree.postOrderByStack(root);
    }
}
