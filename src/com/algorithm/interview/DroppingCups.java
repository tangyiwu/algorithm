package com.algorithm.interview;

/**
 * 有一种玻璃杯质量确定但未知，需要检测。
 * 有一栋100层的大楼，该种玻璃杯从某一层楼扔下，刚好会碎。
 * 现给你两个杯子，问怎样检测出这个杯子的质量，即找到在哪一层楼刚好会碎？
 * <p>
 * W(n, k) = 1 + min{max(W(n -1, x -1), W(n, k - x))}, x in {2, 3, ……，k}
 */
public class DroppingCups {

    int droppingCups(int cups, int floors) {
        int[][] temps = new int[cups + 1][floors + 1];
        for (int i = 0; i < floors + 1; i++) {
            temps[0][i] = 0;
            temps[1][i] = i;
        }

        return temps[cups][floors];
    }
}
