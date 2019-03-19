package com.algorithm.leetcode.easy;

public class LeetCode292_NimGame {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

    public static void main(String[] args) {
        LeetCode292_NimGame nimGame = new LeetCode292_NimGame();
        System.out.println(nimGame.canWinNim(1));
        System.out.println(nimGame.canWinNim(2));
        System.out.println(nimGame.canWinNim(3));
        System.out.println(nimGame.canWinNim(4));
        System.out.println(nimGame.canWinNim(5));
        System.out.println(nimGame.canWinNim(6));
        System.out.println(nimGame.canWinNim(7));
    }
}
