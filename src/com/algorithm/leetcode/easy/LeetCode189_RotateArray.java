package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

public class LeetCode189_RotateArray {
    /**
     * time: O(n)
     * space: O(n)
     */
    public void rotate(int[] nums, int k) {
        int[] copy = nums.clone();
        for (int i = 0; i < copy.length; i++) {
            int index = (i + k) % nums.length;
            nums[index] = copy[i];
        }
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public void rotate2(int[] nums, int k) {
        int moveCnt = 0;
        for (int startMove = 0; startMove < nums.length; startMove++) {
            int preIndex = startMove;
            int waitMove = nums[preIndex];
            while (true) {
                int index = (preIndex + k) % nums.length;
                int tmp = nums[index];
                nums[index] = waitMove;
                moveCnt++;
                preIndex = index;
                waitMove = tmp;
                if (preIndex == startMove || moveCnt == nums.length) {
                    break;
                }
            }
            if (moveCnt == nums.length) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        LeetCode189_RotateArray rotateArray = new LeetCode189_RotateArray();
        rotateArray.rotate2(a, 3);
        ArrayUtil.printArray(a);
        int[] b = {-1, -100, 3, 99};
        rotateArray.rotate2(b, 2);
        ArrayUtil.printArray(b);
    }
}
