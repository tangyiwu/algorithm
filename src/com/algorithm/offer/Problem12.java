package com.algorithm.offer;

public class Problem12 {
    int[][] next = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean hasPath(char[][] matrix, char[] str) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] marks = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marks, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marks, int pathLen, int r, int c) {
        if (pathLen == str.length) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marks[r][c]) {
            return false;
        }
        marks[r][c] = true;
        for (int i = 0; i < next.length; i++) {
            if (backtracking(matrix, str, marks, pathLen + 1, r + next[i][0], c + next[i][1])) {
                return true;
            }
        }
        marks[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        char[] str = {'b', 'f', 'c', 'e'};
        Problem12 problem12 = new Problem12();
        System.out.println(problem12.hasPath(matrix, str));
    }
}
