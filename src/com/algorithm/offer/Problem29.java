package com.algorithm.offer;

/**
 * 顺时针打印矩阵
 */
public class Problem29 {
    private int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return;
        }
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int x = 0, y = -1;
        int count = 0;
        int size = matrix.length * matrix[0].length;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                x += next[0][0];
                y += next[0][1];
                if (count >= size) {
                    return;
                }
                System.out.print(matrix[x][y] + " ");
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                x += next[1][0];
                y += next[1][1];
                if (count >= size) {
                    return;
                }
                System.out.print(matrix[x][y] + " ");
                count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                x += next[2][0];
                y += next[2][1];
                if (count >= size) {
                    return;
                }
                System.out.print(matrix[x][y] + " ");
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                x += next[3][0];
                y += next[3][1];
                if (count >= size) {
                    return;
                }
                System.out.print(matrix[x][y] + " ");
                count++;
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };
        Problem29 problem29 = new Problem29();
        problem29.printMatrix(matrix);
        System.out.println();
        problem29.printMatrix(matrix2);
        System.out.println();
        problem29.printMatrix(matrix3);
    }
}
