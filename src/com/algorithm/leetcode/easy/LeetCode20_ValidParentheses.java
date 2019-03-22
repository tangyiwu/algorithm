package com.algorithm.leetcode.easy;

import java.util.Stack;

/**
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class LeetCode20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre;
            if (!stack.isEmpty()) {
                pre = stack.pop();
                stack.push(pre);
            } else {
                pre = '\0';
            }
            if (isSameTypeBracket(pre, cur)) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }

    private boolean isSameTypeBracket(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}');
    }

    public static void main(String[] args) {
        LeetCode20_ValidParentheses validParentheses = new LeetCode20_ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
    }
}
