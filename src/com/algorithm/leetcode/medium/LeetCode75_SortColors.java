package com.algorithm.leetcode.medium;

import com.algorithm.utils.ArrayUtil;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 思路：双重for循环
 */
public class LeetCode75_SortColors {
    public void sortColors(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, p, i);
                p++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, p, i);
                p++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        LeetCode75_SortColors solution = new LeetCode75_SortColors();
        solution.sortColors(nums);
        ArrayUtil.printArray(nums);
    }
}
