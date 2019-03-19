package com.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，从他的下一个小朋友开始，继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演。
 * 0 1 2 3 4    size=5, start=0, m=5
 * 0 1 2 3      size=4, start=0, m=5
 * 1 2 3
 * 1 3
 * 1
 * <p>
 * 0 1 2 3 4 0 1 2 3 4
 */
public class Problem62 {
    public int ringLeft(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (ringLeft(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {
        Problem62 problem62 = new Problem62();
        System.out.println(problem62.ringLeft(5, 5));
    }
}
