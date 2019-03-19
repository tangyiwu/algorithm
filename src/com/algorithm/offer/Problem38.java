package com.algorithm.offer;

/**
 * 字符串的排列
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Problem38 {
    public void showCharsCombination(char[] str) {
        if (str == null || str.length <= 0) {
            return;
        }
        boolean[] state = new boolean[str.length];
        find(str, state, "", 0);
    }

    private void find(char[] str, boolean[] state, String select, int len) {
        if (len == str.length) {
            System.out.println(select);
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (!state[i]) {
                state[i] = true;
                find(str, state, select + str[i], len + 1);
                state[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd'};
        Problem38 problem38 = new Problem38();
        problem38.showCharsCombination(str);
    }

}
