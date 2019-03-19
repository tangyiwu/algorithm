package com.algorithm.offer;

/**
 * 机器人的运动范围
 * 地上有一个 m 行和 n 列的方格。
 * 一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class Problem13 {
    private int cnt;
    int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows;
    private int cols;
    private int threshold;

    public Problem13(int rows, int cols, int threshold) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
    }

    private int moveCount() {
        boolean[][] marks = new boolean[rows][cols];
        dfs(0, 0, marks);
        return cnt;
    }

    private void dfs(int r, int c, boolean[][] marks) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marks[r][c]) {
            return;
        }
        if (digitSum(r) + digitSum(c) <= threshold) {
            marks[r][c] = true;
            cnt++;
            for (int[] n : next) {
                dfs(r + n[0], c + n[1], marks);
            }
        }
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem13 problem13 = new Problem13(40, 40, 18);
        System.out.println(problem13.moveCount());
    }
}
