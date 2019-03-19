package com.algorithm.string;


/**
 * "abcde" -> "abdefghi"
 * 只能有三种操作：
 * 1. insert
 * 2. delete
 * 3. replace
 */
public class StringTransform {
    public int transform(char[] src, char[] dest) {
        // matrix[i][j] means operation count that transform str[0...i-1] to dest[0...j-1]
        int[][] matrix = new int[src.length + 1][dest.length + 1];
        for (int i = 1; i <= src.length; i++) {
            matrix[i][0] = i;
        }
        for (int i = 1; i <= dest.length; i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i <= src.length; i++) {
            for (int j = 1; j <= dest.length; j++) {
                if (src[i - 1] == dest[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.min(
                            matrix[i - 1][j - 1] + 1,//for replace
                            Math.min(
                                    matrix[i - 1][j] + 1,//for delete
                                    matrix[i][j - 1] + 1//for insert
                            ));
                }
            }
        }
        return matrix[src.length][dest.length];
    }

    public static void main(String[] args) {
        StringTransform transform = new StringTransform();
        System.out.println(transform.transform("sfdxbqw".toCharArray(), "gfdgw".toCharArray()));
    }
}
