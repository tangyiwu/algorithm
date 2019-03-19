package com.algorithm.offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class Problem31 {
    public boolean isStackPopSequence(int[] a, int[] b, Stack<Integer> stack, int left, int popCount) {
        if (a == null || b == null) {
            return false;
        }
        if (popCount == b.length) {
            return true;
        }
        if (left <= 0) {
            while (!stack.isEmpty()) {
                if (stack.pop() != b[popCount]) {
                    return false;
                }
                popCount++;
            }
            return true;
        }
        if (!stack.isEmpty() && stack.peek() == b[popCount]) {
            stack.pop();
            popCount++;
        } else {
            stack.push(a[a.length - left]);
            left--;
        }
        return isStackPopSequence(a, b, stack, left, popCount);
    }

    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        for (; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        int[] c = {4, 3, 5, 1, 2};
        int[] d = {3, 2, 1, 4, 5};
        Problem31 problem31 = new Problem31();
        System.out.println(problem31.isStackPopSequence(a, b, new Stack<>(), 5, 0));
        System.out.println(problem31.isStackPopSequence(a, c, new Stack<>(), 5, 0));
        System.out.println(problem31.isStackPopSequence(a, d, new Stack<>(), 5, 0));

        System.out.println();
        System.out.println(problem31.isPopOrder(a, b));
        System.out.println(problem31.isPopOrder(a, c));
        System.out.println(problem31.isPopOrder(a, d));
    }
}
