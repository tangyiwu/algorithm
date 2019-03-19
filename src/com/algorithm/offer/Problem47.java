package com.algorithm.offer;

/**
 * 礼物的最大价值
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 */
public class Problem47 {

    public int findMostValuable(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        return mostValuable(matrix, matrix[0][0], 0, 0, r, c);
    }

    private int mostValuable(int[][] matrix, int value, int i, int j, int r, int c) {
        if ((i == r - 1 && j == c - 2) ||
                (i == r - 2 && j == c - 1)) {
            return value + matrix[r - 1][c - 1];
        }
        int toRight = value;
        if (j < c - 1) {
            toRight = mostValuable(matrix, value + matrix[i][j + 1], i, j + 1, r, c);
        }
        int toLeft = value;
        if (i < r - 1) {
            toLeft = mostValuable(matrix, value + matrix[i + 1][j], i + 1, j, r, c);
        }
        return toRight > toLeft ? toRight : toLeft;
    }

    public int getMostValue(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }
        int[] dp = new int[matrix.length];
        for (int[] values : matrix) {
            dp[0] += values[0];
            for (int i = 1; i < values.length; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + values[i];
            }
        }
        return dp[matrix.length - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        Problem47 problem47 = new Problem47();
        System.out.println(problem47.findMostValuable(a));
        System.out.println(problem47.getMostValue(a));
    }
}
