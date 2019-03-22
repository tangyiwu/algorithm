package com.algorithm.interview;

public class Solution3 {
    /**
     * eg:   x=7, y=11, z=3
     * need: [2, 8, 4, 3, 2]
     * wait: [0, 0, 2, 2, 8]
     * time     X   Y   Z
     * 0        2   8
     * 1        2   8
     * 2        4   8
     * 3        4   8
     * 4        4   8
     * 5        4   8
     * 6            8   3
     * 7            8   3
     * 8            2   3
     */
    public int solution(int[] A, int X, int Y, int Z) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }
        int[] state = new int[3];
        int cur = 0;
        int waitTime = 0;
        for (int i = 0; i <= max; i++) {
            int pre = cur;
            while (cur < A.length) {
                if (state[0] == 0) { // X is unoccupied
                    if (A[cur] <= X) {
                        state[0] = A[cur];
                        cur++;
                        continue;
                    }
                }
                if (state[1] == 0) {
                    if (A[cur] <= Y) {
                        state[1] = A[cur];
                        cur++;
                        continue;
                    }
                }
                if (state[2] == 0) {
                    if (A[cur] <= Z) {
                        state[2] = A[cur];
                        cur++;
                    }
                }
                break;
            }
            if (cur == pre) {
                if (cur == 0) {
                    return -1;
                }
                if (A[cur] > X - state[0] && A[cur] > Y - state[1] && A[cur] > Z - state[1]) {
                    return waitTime;
                }
            }
            if (cur >= A.length) {
                return waitTime;
            }
            waitTime++;
            if (state[0] > 0) {
                state[0]--;
                X--;
            }
            if (state[1] > 0) {
                state[1]--;
                Y--;
            }
            if (state[2] > 0) {
                state[2]--;
                Z--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] a = {2, 8, 4, 3, 2};
        int[] b = {7, 11, 2};
        int[] c = {12, 1};
        System.out.println(solution3.solution(a, 7, 11, 3));
        System.out.println(solution3.solution(b, 7, 11, 3));
        System.out.println(solution3.solution(c, 7, 11, 3));
    }
}
