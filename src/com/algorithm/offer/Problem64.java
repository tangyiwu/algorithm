package com.algorithm.offer;

/**
 * 剑指 offer 64题
 * 求 1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C。
 */
public class Problem64 {
    public int sum(int n) {
        int s = n;
        boolean b = (n > 0) && ((s += sum(n - 1)) > 0);
        return s;
    }

    public static void main(String[] args) {
        Problem64 problem64 = new Problem64();
        System.out.println(problem64.sum(100));
        // 10   --> 2
        // 11   --> 3
        // 01
        //101   --> 5
        System.out.println(2^3);//  1
    }
}
