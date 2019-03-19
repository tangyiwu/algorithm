package com.algorithm.array;

/**
 * 顺时针打印二元数组
 * 例如：
 * 1, 2, 3
 * 4, 5 ,6
 * 7, 8, 9
 * <p>
 * output: 1, 2, 3, 6, 9, 8, 7, 4, 5
 * </p>
 */
public class ClockwisePrintMatrix {
    int top;
    int right;
    int bottom;
    int left;

    public void printMatrix(int[][] a) {
        top = 0;
        right = a[0].length - 1;
        bottom = a.length - 1;
        left = 0;
        while (true) {
            if (left > right || top > bottom) {
                break;
            } else {
                onceCyclePrint(a);
            }
        }
    }

    private void onceCyclePrint(int[][] a) {
        int i = top, j;
        if (left > right) {
            return;
        }
        for (j = left; j <= right; j++) { // 从左到右
            System.out.print(a[i][j] + ", ");
        }
        top++;
        j = right;
        if (top > bottom) {
            return;
        }
        for (i = top; i <= bottom; i++) { // 从上到下
            System.out.print(a[i][j] + ", ");
        }
        right--;
        i = bottom;
        if (right < left) {
            return;
        }
        for (j = right; j >= left; j--) { // 从右到左
            System.out.print(a[i][j] + ", ");
        }
        bottom--;
        j = left;
        if (bottom < top) {
            return;
        }
        for (i = bottom; i >= top; i--) { // 从下到上
            System.out.print(a[i][j] + ", ");
        }
        left++;
        i = top;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] b = {
                {1, 2, 3, 4},
                {4, 6, 7, 8}
        };
        int[][] c = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        ClockwisePrintMatrix printMatrix = new ClockwisePrintMatrix();
        printMatrix.printMatrix(a);
        System.out.println();
        printMatrix.printMatrix(b);
        System.out.println();
        printMatrix.printMatrix(c);
    }
}
