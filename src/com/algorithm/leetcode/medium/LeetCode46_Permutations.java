package com.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        search(nums, visit, solution, new ArrayList<>());
        return solution;
    }

    private void search(int[] nums, boolean[] visit, List<List<Integer>> result, List<Integer> select) {
        if (select.size() == nums.length) {
            result.add(new ArrayList<>(select));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select.add(nums[i]);
                search(nums, visit, result, select);
                visit[i] = false;
                select.remove(select.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LeetCode46_Permutations permutations = new LeetCode46_Permutations();
        List<List<Integer>> ret = permutations.permute(nums);
        for (List<Integer> list : ret) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
