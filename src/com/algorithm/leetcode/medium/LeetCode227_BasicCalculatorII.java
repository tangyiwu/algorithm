package com.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 * <p>
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 * <p>
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 */
public class LeetCode227_BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        LinkedList<Object> queue = new LinkedList<>();
        int n = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                queue.add(n);
                n = 0;
                queue.add(c);
                continue;
            }
            n = n * 10 + (c - '0');
        }
        queue.add(n);
        Stack<Integer> stack = new Stack<>();
        stack.push((int) queue.poll());
        while (!queue.isEmpty()) {
            Object cur = queue.poll();
            if (cur instanceof Character) {
                char c = (char) cur;
                if (c == '*') {
                    int pre = stack.pop();
                    int next = (int) queue.poll();
                    stack.push(pre * next);
                } else if (c == '/') {
                    int pre = stack.pop();
                    int next = (int) queue.poll();
                    stack.push(pre / next);
                } else if (c == '-') {
                    stack.push(-1 * (int) queue.poll());
                } else {
                    stack.push((int) queue.poll());
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode227_BasicCalculatorII basicCalculatorII = new LeetCode227_BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("3 +2 * 2"));
        System.out.println(basicCalculatorII.calculate("123"));
        System.out.println(basicCalculatorII.calculate("3/2"));
        System.out.println(basicCalculatorII.calculate("3 + 5 / 2"));
        System.out.println(basicCalculatorII.calculate("0+0"));
    }
}
