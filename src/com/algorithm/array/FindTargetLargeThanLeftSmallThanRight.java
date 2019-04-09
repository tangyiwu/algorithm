package com.algorithm.array;

/**
 * 找到比左边大比右边小的数组下标，要求复杂度为n
 */
public class FindTargetLargeThanLeftSmallThanRight {
    public int findTarget(int[] a) {
        if (a.length <= 2) {
            return -1;
        }
        int[] min = new int[a.length];
        for (int i = a.length - 2; i >= 0; i--) {
            if (i == a.length - 2) {
                min[i] = a[a.length - 1];
            } else {
                min[i] = Math.min(min[i + 1], a[i + 1]);
            }
        }
        int[] max = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            if (i == 1) {
                max[i] = a[0];
            } else {
                max[i] = Math.max(max[i - 1], a[i - 1]);
            }
            if (a[i] > max[i] && a[i] < min[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTargetLargeThanLeftSmallThanRight findTarget = new FindTargetLargeThanLeftSmallThanRight();
        int[] a = {1, 3, 2, 5, 7};
        System.out.println(findTarget.findTarget(a));
        int[] b = {1, 5, 4, 3, 6, 8, 7, 10};
        System.out.println(findTarget.findTarget(b));
    }
}
