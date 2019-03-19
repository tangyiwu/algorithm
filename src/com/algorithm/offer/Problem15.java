package com.algorithm.offer;

/**
 * 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 * n&(n-1)
 * 该位运算去除 n 的位级表示中最低的那一位。
 */
public class Problem15 {
    public int numberOf1(int number) {
        int cnt = 0;
        while (number != 0) {
            cnt++;
            number &= (number - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem15 problem15 = new Problem15();
        System.out.println(problem15.numberOf1(3));
    }
}
