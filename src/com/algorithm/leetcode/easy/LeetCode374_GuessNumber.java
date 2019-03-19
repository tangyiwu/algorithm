package com.algorithm.leetcode.easy;

public class LeetCode374_GuessNumber {
    private int n;
    private int pick;

    public LeetCode374_GuessNumber(int n, int pick) {
        this.n = n;
        this.pick = pick;
    }

    public int guess(int num) {
        if (num == pick) {
            return 0;
        } else if (num < pick) {
            return -1;
        } else {
            return 1;
        }
    }

    public int guessNumber(int n) {
        for (int i = 1; i < n; i++)
            if (guess(i) == 0)
                return i;
        return n;
    }

    public static void main(String[] args) {
        LeetCode374_GuessNumber guessNumber = new LeetCode374_GuessNumber(10, 6);
        System.out.println(guessNumber.guessNumber(1));
    }
}
