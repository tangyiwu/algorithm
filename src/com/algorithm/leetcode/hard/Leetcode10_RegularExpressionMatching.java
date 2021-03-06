package com.algorithm.leetcode.hard;

/**
 * Here are some conditions to figure out:
 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 * 3, If p.charAt(j) == '*':
 * here are two sub conditions:
 * 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 * 2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
 * dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
 * or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
 * or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 */
public class Leetcode10_RegularExpressionMatching {
    /**
     * 动态规划
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean myMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // "" "a*"
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // ab ab
                // ab a.
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }

                if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        // aa aab*
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        continue;
                    }
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        // aaa a*
                        // a a*
                        // b ba*
                        dp[i + 1][j + 1] = dp[i][j + 1]
                                || dp[i + 1][j]
                                || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 递归实现
     */
    public boolean isMatchByRecurse(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // bc a*bc
            // aa a*
            return isMatchByRecurse(s, p.substring(2))
                    || (firstMatch && isMatchByRecurse(s.substring(1), p));
        } else {
            return firstMatch && isMatchByRecurse(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        Leetcode10_RegularExpressionMatching regularExpressionMatching = new Leetcode10_RegularExpressionMatching();
        System.out.println("===> isMatch:");
        System.out.println(regularExpressionMatching.isMatch("aa", "a"));
        System.out.println(regularExpressionMatching.isMatch("aa", "a*"));
        System.out.println(regularExpressionMatching.isMatch("ab", ".*"));
        System.out.println(regularExpressionMatching.isMatch("aab", "c*a*b"));
        System.out.println(regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
        System.out.println("===> myMatch:");
        System.out.println(regularExpressionMatching.myMatch("aa", "a"));
        System.out.println(regularExpressionMatching.myMatch("aa", "a*"));
        System.out.println(regularExpressionMatching.myMatch("ab", ".*"));
        System.out.println(regularExpressionMatching.myMatch("aab", "c*a*b"));
        System.out.println(regularExpressionMatching.myMatch("mississippi", "mis*is*p*."));
        System.out.println(regularExpressionMatching.myMatch("aaa", "ab*a*c*a"));
        System.out.println("===> isMatchByRecurse");
        System.out.println(regularExpressionMatching.isMatchByRecurse("aa", "a"));
        System.out.println(regularExpressionMatching.isMatchByRecurse("aa", "a*"));
        System.out.println(regularExpressionMatching.isMatchByRecurse("ab", ".*"));
        System.out.println(regularExpressionMatching.isMatchByRecurse("aab", "c*a*b"));
        System.out.println(regularExpressionMatching.isMatchByRecurse("mississippi", "mis*is*p*."));
    }
}
