package com.algorithm.leetcode.medium;

/**
 * 1*2=2
 * 01
 * 10
 * calculate process : 01<<1 => 10
 * <p>
 * 2=10=2^1
 * 3=11=2^1+2^0
 * 6=110=2<<1 + 2<<0 = 4+2=6
 * 100
 * 010
 * 110
 * <p>
 * 6/2=3
 * 6: 110
 * 2: 010 => 2^1
 * 110 - (110>>1) = 110-11 = 6-3=3
 * <p>
 * multiply:
 * how to calculate product=a*b in computer system;
 * <p>
 * Init:
 * product = 0;
 * Loop:
 * oneDigit = calculate(b)
 * removeOneDigit(b)
 * product += (a << oneDigit)
 * <p>
 * divide:
 * how to calculate dividend/divisor
 * Loop when divisor is not 0:
 * oneDigit = calculate(divisor)
 * dividend -= (dividend>>oneDigit)
 * removeOneDigit(divisor)
 * <p>
 * 1101
 */
public class LeetCode29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }
        if (dividend == divisor) return 1;
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        boolean minus = (dividend < 0) ^ (divisor < 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        int res = 0;
        int u = 1;
        while (dividend <= -divisor) {
            dividend += divisor;
            res += u;
            if ((divisor & (1 << 30)) != 0) break;
            divisor <<= 1;
            u <<= 1;
        }
        while (divisor > 0) {
            if (dividend <= -divisor) {
                dividend += divisor;
                res += u;
            }
            divisor >>= 1;
            u >>= 1;
        }
        return minus ? -res : res;
    }

    /**
     * 1+2=3=2^0+2^1
     * 01
     * 10
     * 01 ^ 10 = 11
     * 01 & 10 = 00, 00<<1 = 0
     */
    private int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

    private int AddIter(int a, int b) {
        while (b != 0) {
            int t = (a & b) << 1;
            a = a ^ b;
            b = t;
        }
        return a;
    }

    //-a=(~a)+1
    private int Minus(int a, int b) {
        return AddIter(a, (~b) + 1);
    }

    /**
     * 1011
     * 1010
     * --------
     * 0010110 (1011<<1,相当于乘以0010)
     * 1011000 (1011<<3,相当于乘以1000)
     * --------
     * 1101110
     */
    private int multiply(int a, int b) {
        int res = 0;
        int i = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res += (a << i);
            }
            b >>= 1;
            i++;
        }
        return res;
    }

    //       12                 11
    //  --------    ----------------
    // 12   144      1100   10010000
    //      12               1100
    //  --------    ----------------
    //       24               1100
    //       24               1100
    //  --------    ----------------
    //        0                  0
    private int Sub(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (a < b) {
            return 0;
        }
        return AddIter(Sub(Minus(a, b), b), 1);
    }

    private int SubIter(int a, int b) {
        if (b == 1) {
            return a;
        }
        int res = 0;
        while (a >= b) {
            a = Minus(a, b);
            res = AddIter(res, 1);
        }
        return res;
    }

    /**
     * 取反
     */
    private int negative(int a) {
        return (~a) + 1;
    }

    private boolean isPositive(int a) {
        return (a & 0x80000000) == 0;
    }

    private boolean isNegative(int a) {
        return (a & 0x80000000) == 0x80000000;
    }

    private boolean isGreatOrEqual(int a, int b) {
        return !isNegative(Minus(a, b));
    }

    private boolean isZero(int a) {
        return a == 0;
    }

    public static void main(String[] args) {
        LeetCode29_DivideTwoIntegers divideTwoIntegers = new LeetCode29_DivideTwoIntegers();
        System.out.println(divideTwoIntegers.Add(2, 6));
        System.out.println(divideTwoIntegers.Minus(10, 5));
        System.out.println(divideTwoIntegers.multiply(3, 5));
        System.out.println(divideTwoIntegers.multiply(-3, 5));
        System.out.println(divideTwoIntegers.Sub(3, 5));
        System.out.println(divideTwoIntegers.Sub(5, 3));
        System.out.println(divideTwoIntegers.Sub(6, 3));
        System.out.println(divideTwoIntegers.SubIter(15, 3));
        System.out.println(divideTwoIntegers.divide(10, 3));
        System.out.println(divideTwoIntegers.divide(7, -3));
        System.out.println(divideTwoIntegers.divide(-2147483648, -1));
        System.out.println(divideTwoIntegers.divide(2147483647, 2));
        System.out.println(divideTwoIntegers.divide(-2147483648, -2147483648));
    }
}
