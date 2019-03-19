package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Myers差分算法
 * 1、迭代d，d的取值范围为0到n+m，其中n和m分别代表源文本和目标文本的长度（这里我们选择以行为单位）
 * 2、每个d内部，迭代k，k的取值范围为-d到d，以2为步长，也就是-d，-d + 2，-d + 2 + 2…
 * 3、使用一个数组v，以k值为索引，存储最优坐标的x值
 * 4、将每个d对应的v数组存储起来，后面回溯的时候需要用
 * 5、当我们找到一个d和k，到达目标坐标(n, m)时就跳出循环
 * 6、使用上面存储的v数组（每个d对应一个这样的数组），从终点反向得出路径
 */
public class MyersDiff {
    /**
     * shortest edit script
     */
    public int diff(String src, String dest) {
        if (src == null || dest == null) {
            int l0 = src != null ? src.length() : 0;
            int l1 = dest != null ? dest.length() : 0;
            return l0 + l1;
        }
        int newLength = src.length();
        int oldLength = dest.length();
        int max = newLength + oldLength;
        List<int[]> vList = new ArrayList<>();
        int x, y;
        loop:
        for (int d = 0; d <= newLength + oldLength; d++) {
            int[] v = new int[max * 2 + 1];
            vList.add(v);
            for (int k = -d; k <= d; k = k + 2) {
                if (k == -d) {
                    x = v[k + 1 + max];
                } else if (k != d && v[k - 1 + max] < v[k + 1 + max]) {
                    x = v[k + 1 + max];
                } else {
                    x = v[k - 1 + max] + 1;
                }
                y = x - k;
                while (x < newLength && y < oldLength && src.charAt(x) == dest.charAt(y)) {
                    x++;
                    y++;
                }
                v[k + max] = x;
                if (x == newLength && y == oldLength) {
                    break loop;
                }
            }
        }
        return vList.size();
    }

    public static void main(String[] args) {
        MyersDiff diff = new MyersDiff();
        System.out.println(diff.diff("ABCABBA", "CBABAC"));
    }

    private static class Snake {
        private int xStart;
        private int yStart;
        private int xEnd;
        private int yEnd;

        public Snake(int xStart, int yStart, int xEnd, int yEnd) {
            this.xStart = xStart;
            this.yStart = yStart;
            this.xEnd = xEnd;
            this.yEnd = yEnd;
        }

        public int getxStart() {
            return xStart;
        }

        public void setxStart(int xStart) {
            this.xStart = xStart;
        }

        public int getyStart() {
            return yStart;
        }

        public void setyStart(int yStart) {
            this.yStart = yStart;
        }

        public int getxEnd() {
            return xEnd;
        }

        public void setxEnd(int xEnd) {
            this.xEnd = xEnd;
        }

        public int getyEnd() {
            return yEnd;
        }

        public void setyEnd(int yEnd) {
            this.yEnd = yEnd;
        }
    }
}
