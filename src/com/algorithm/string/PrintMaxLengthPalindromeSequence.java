package com.algorithm.string;

/**
 * 给定一个字符串
 * 打印最长的回文序列
 * 例如：
 * "abcdcbf" => "bcdcb"
 * "abba"    => "abba"
 * <p>
 * 解法：动态规划
 * </p>
 */
public class PrintMaxLengthPalindromeSequence {
    public String find(String src) {
        if (null == src || src.trim().length() == 0) {
            return null;
        }
        src = src.trim();
        int length = src.length();
        int[][] a = new int[length][length];
        for (int i = length - 1; i >= 0; i--) { // i从大到小
            for (int j = i; j < length; j++) {  // j从小到大
                a[i][j] = calculatePalindromeLength(a, src, i, j);
            }
        }
        int maxLength = 0;// 回文字符串
        String result = null;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (a[i][j] > maxLength) {
                    maxLength = a[i][j];
                    result = src.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    /**
     * 计算a[i][j]的值，表示字符串从i到j的子字符串是否是回文字符串，如果不是，a[i][j]的值为0，否则a[i][j]的值即为回文字符串的长度
     *
     * @param i 字符串位置为i的地方
     * @param j 字符串位置为j的地方
     */
    private int calculatePalindromeLength(int[][] a, String src, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (j - i == 1) {
            if (src.charAt(i) == src.charAt(j)) {
                return 2;
            } else {
                return 0;
            }
        }
        if (j - i >= 2) {
            if (src.charAt(i) == src.charAt(j)) {
                if (a[i + 1][j - 1] > 0) {
                    return a[i + 1][j - 1] + 2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PrintMaxLengthPalindromeSequence palindromeSequence = new PrintMaxLengthPalindromeSequence();
        System.out.println(palindromeSequence.find("abcdedcbf")); // output: bcdedcb
        System.out.println(palindromeSequence.find("aaaabbbccc"));// output: aaaa
        System.out.println(palindromeSequence.find("abba"));      // output: abba
        System.out.println(palindromeSequence.find("abcdef"));    // output: a
    }
}
