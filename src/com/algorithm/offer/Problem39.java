package com.algorithm.offer;

/**
 * 数组中出现次数超过一半的数字
 */
public class Problem39 {
    public int MoreThanHalfNum_Solution(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int majority = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            cnt = (nums[i] == majority) ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        if (cnt > 0) {
            cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == majority) {
                    cnt++;
                }
            }
        }
        return cnt > nums.length / 2 ? majority : 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 2};
        System.out.println(new Problem39().MoreThanHalfNum_Solution(a));
    }
}
