package com.algorithm.interview;

public class Solution {
    //    int[] d = new int[30];
//    int l = 0;
//    int p;
//        while (n > 0) {
//        d[l] = n % 2;
//        n /= 2;
//        l++;
//    }
//        for (p = 1; p < 1 + l; ++p) {
//        int i;
//        boolean ok = true;
//        for (i = 0; i < l - p; ++i) {
//            if (d[i] != d[i + p]) {
//                ok = false;
//                break;
//            }
//        }
//        if (ok) {
//            return p;
//        }
//    }
//        return -1;
    int solution(int n) {
//        int[] d = new int[31];
//        int l = 0;
//        int p;
//        while (n > 0) {
//            d[l] = n % 2;
//            n /= 2;
//            l++;
//        }
//        int maxP = -1;
//        for (p = 1; p <= l / 2; ++p) {
//            int i;
//            boolean ok = true;
//            for (i = 0; i < l - p; ++i) {
//                if (d[l - 1 - i] != d[l - 1 - i - p]) {
//                    ok = false;
//                    break;
//                }
//            }
//            if (ok) {
//                maxP = Math.max(maxP, p);
//            }
//        }
//        return maxP;
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p <= l / 2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[l - 1 - i] != d[l - 1 - i - p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1));
        System.out.println(solution.solution(7));
        System.out.println(solution.solution(955));
        System.out.println(solution.solution(1000000000));
        System.out.println(solution.solution(136));
        System.out.println(solution.solution(15326));
        System.out.println(solution.solution(127));
        System.out.println(solution.solution(365));
        // 1000 1000 => 8+128=136
        // 111 1111, 1111 1111, 1111 1111, 1111 1111
//        System.out.println(solution.solution(Integer.MAX_VALUE));
    }
}
