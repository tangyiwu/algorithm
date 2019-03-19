package com.algorithm.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 */
public class Problem45 {
    public String getMin(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem45().getMin(new int[]{3, 32, 321}));
    }
}
