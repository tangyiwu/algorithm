package com.algorithm.offer;

/**
 * 打印从 1 到最大的 n 位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * <p>
 * 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 * <p>
 * 使用回溯法得到所有的数。
 */
public class Problem17 {
    void print1ToMaxDigits(int n) {
        char[] number = new char[n];
        print1ToMaxDigits(number, 0);
    }

    void print1ToMaxDigits(char[] number, int digit) {
        if (number.length == digit) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxDigits(number, digit + 1);
        }
    }

    void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        for (int i = index; i < number.length; i++) {
            System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        problem17.print1ToMaxDigits(10);
    }
}
