package com.algorithm.offer;

/**
 * 从 1 到 n 整数中 1 出现的次数
 */
public class Problem43 {
    // 415
    public int find1Times(int n) {
        int cnt = 0;
        int round = n;
        int base = 1;
        int weight;
        while (round > 0) {
            weight = round % 10;
            round = round / 10;
            cnt += round * base;
            if (weight == 1) {
                cnt += (n % base + 1);
            } else if (weight > 1) {
                cnt += base;
            }
            base *= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Problem43().find1Times(10000000));
    }
}
