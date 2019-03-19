package com.algorithm.offer;

/**
 * n 个骰子的点数
 * 把 n 个骰子仍在地上，求点数和为 s 的概率。
 */
public class Problem60 {
    public int dicesSum(int n, int s) {
        if (n == 1) {
            if (s >= 1 && s <= 6) {
                return 1;
            }
            return 0;
        } else {
            return dicesSum(n - 1, s - 1) + dicesSum(n - 1, s - 2) + dicesSum(n - 1, s - 3)
                    + dicesSum(n - 1, s - 4) + dicesSum(n - 1, s - 5) + dicesSum(n - 1, s - 6);
        }
    }

    public static void main(String[] args) {
        Problem60 problem60 = new Problem60();
        for (int n = 1; n <= 6; n++) {
            for (int i = n; i <= n * 6; i++) {
                int all = (int) Math.pow(6, n);
                int count = problem60.dicesSum(n, i);
                System.out.println(n + "个骰子摇中" + i + "的概率是\t" + count + "/" + all);
            }
        }
    }
}
