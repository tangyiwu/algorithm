package com.algorithm.interview;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.isEmpty() || str.equalsIgnoreCase("e") || str.equalsIgnoreCase("q") || str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("quit")) {
                break;
            }
            Solution4 solution4 = new Solution4();
            System.out.println(solution4.calculate(str));
        }
    }

    public String calculate(String str) {
        LinkedList<String> positiveNum = new LinkedList<>();
        LinkedList<String> negativeNum = new LinkedList<>();
        boolean curNegative = false;
        int cur = 0;
        for (char c : str.toCharArray()) {
            if (c == '-' || c == '+' || c == ' ') {
                if (cur > 0) {
                    if (curNegative) {
                        negativeNum.add(String.valueOf(cur));
                    } else {
                        positiveNum.add(String.valueOf(cur));
                    }
                    cur = 0;
                }
                if (c == '-') {
                    curNegative = true;
                } else if (c == '+') {
                    curNegative = false;
                }
            } else {
                cur = cur * 10 + (c - '0');
            }
        }
        if (cur > 0) {
            if (curNegative) {
                negativeNum.add(String.valueOf(cur));
            } else {
                positiveNum.add(String.valueOf(cur));
            }
        }
        String positiveSum = sum(positiveNum);
        String negativeSum = sum(negativeNum);
        if (positiveSum.isEmpty()) {
            return "-" + negativeSum;
        }
        if (negativeSum.isEmpty()) {
            return positiveSum;
        }
        int compare = compare(positiveSum, negativeSum);
        if (compare > 0) {
            return sub(positiveSum, negativeSum);
        } else if (compare < 0) {
            return "-" + sub(negativeSum, positiveSum);
        } else {
            return "0";
        }
    }

    private int compare(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2) {
            return -1;
        } else if (len1 > len2) {
            return 1;
        } else {
            for (int i = 0; i < len1; i++) {
                if (str1.charAt(i) > str2.charAt(i)) {
                    return 1;
                } else if (str1.charAt(i) < str2.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private String sum(LinkedList<String> positiveNum) {
        String positiveSum = "";
        if (!positiveNum.isEmpty()) {
            positiveSum = positiveNum.poll();
        }
        while (!positiveNum.isEmpty()) {
            positiveSum = addPositive(positiveSum, positiveNum.poll());
        }
        return positiveSum;
    }

    private String addPositive(String num1, String num2) {
        // 1234
        //   17
        int len = Math.max(num1.length(), num2.length()) + 1;
        char[] ch = new char[len];
        char ch1, ch2;
        int digitSum = 0;
        int round = 0;
        for (int i = len - 1; i >= 0; i--) {
            int n1 = num1.length() - 1 - (len - i - 1);
            int n2 = num2.length() - 1 - (len - i - 1);
            if (n1 >= 0 && n1 < num1.length()) {
                ch1 = num1.charAt(n1);
            } else {
                ch1 = ' ';
            }
            if (n2 >= 0 && n2 < num2.length()) {
                ch2 = num2.charAt(n2);
            } else {
                ch2 = ' ';
            }
            digitSum = round;
            if (ch1 != ' ') {
                digitSum += (ch1 - '0');
            }
            if (ch2 != ' ') {
                digitSum += (ch2 - '0');
            }
            if (digitSum > 9) {
                round = 1;
                ch[i] = (char) ('0' + (digitSum % 10));
            } else {
                round = 0;
                ch[i] = (char) ('0' + digitSum);
            }
        }
        return formatNum(ch);
    }

    private String formatNum(char[] ch) {
        int offset = 0;
        for (char c : ch) {
            if (c == '0') {
                offset++;
            } else {
                break;
            }
        }
        String result = String.valueOf(ch, offset, ch.length - offset);
        if (result.isEmpty()) {
            return "0";
        } else {
            return result;
        }
    }

    private String sub(String n1, String n2) {
        //1234
        //  34
        int round = 0;
        int len = Math.max(n1.length(), n2.length());
        char[] ch = new char[len];
        char c1, c2;
        int digitSub = 0;
        for (int i = len - 1; i >= 0; i--) {
            int p1 = n1.length() - 1 - (len - i - 1);
            int p2 = n2.length() - 1 - (len - i - 1);
            if (p1 >= 0 && p1 < n1.length()) {
                c1 = n1.charAt(p1);
            } else {
                c1 = ' ';
            }
            if (p2 >= 0 && p2 < n2.length()) {
                c2 = n2.charAt(p2);
            } else {
                c2 = ' ';
            }
            if (round > 0) {
                c1 -= 1;
            }
            digitSub = c1 - '0';
            if (c2 != ' ') {
                if (digitSub < (c2 - '0')) {
                    digitSub = 10 + digitSub - (c2 - '0');
                    round = 1;
                } else {
                    digitSub = digitSub - (c2 - '0');
                    round = 0;
                }
            } else {
                round = 0;
            }
            ch[i] = (char) ('0' + digitSub);
        }
        return formatNum(ch);
    }
}
