package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

public class LeetCode167_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        LeetCode167_TwoSum twoSum = new LeetCode167_TwoSum();
        ArrayUtil.printArray(twoSum.twoSum(a, 9));
    }
}
