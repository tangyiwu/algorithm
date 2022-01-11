package com.algorithm.leetcode.medium;

import java.util.*;

public class LeetCode139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        LeetCode139_WordBreak demo = new LeetCode139_WordBreak();
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(demo.wordBreak("leetcode", wordDict));
    }
}
