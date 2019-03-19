package com.algorithm.offer;

import java.util.ArrayList;

/**
 * 和为 S 的两个数字
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 */
public class Problem57 {
    public int[] findTwoSum(int[] a, int sum) {
        int i = 0;
        int j = a.length - 1;
        int[] result = new int[2];
        while (i < j) {
            if (a[i] + a[j] == sum) {
                result[0] = a[i];
                result[1] = a[j];
                break;
            } else if (a[i] + a[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> sumSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < curSum) {
            if (curSum < sum) {
                end++;
                curSum += end;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                ArrayList<Integer> sequence = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    sequence.add(i);
                }
                result.add(sequence);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Problem57 problem57 = new Problem57();
        int[] b = problem57.findTwoSum(a, 13);
        System.out.println(b[0] + " " + b[1]);
        ArrayList<ArrayList<Integer>> result = problem57.sumSequence(100);
        for (ArrayList<Integer> sequence : result) {
            System.out.println();
            for (Integer e : sequence) {
                System.out.print(e + " ");
            }
        }
    }
}
