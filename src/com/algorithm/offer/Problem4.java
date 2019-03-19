package com.algorithm.offer;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Problem4 {
    public boolean contain(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1; ; ) {
            if (i >= matrix.length || j < 0) {
                return false;
            }
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
            if (matrix[i][j] > target) {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.contain(matrix, 5));
        System.out.println(problem4.contain(matrix, 20));
    }
}
