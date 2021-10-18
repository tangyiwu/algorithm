package com.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时间复杂度仍然为 O(N^3)O(N
 * 3
 * )，毕竟我们还是没有跳出三重循环的大框架。然而它是很容易继续优化的，可以发现，如果我们固定了前两重循环枚举到的元素 aa 和 bb，那么只有唯一的 cc 满足 a+b+c=0a+b+c=0。当第二重循环往后枚举一个元素 b'b
 * ′
 * 时，由于 b' > bb
 * ′
 * >b，那么满足 a+b'+c'=0a+b
 * ′
 * +c
 * ′
 * =0 的 c'c
 * ′
 * 一定有 c' < cc
 * ′
 * <c，即 c'c
 * ′
 * 在数组中一定出现在 cc 的左侧。也就是说，我们可以从小到大枚举 bb，同时从大到小枚举 cc，即第二重循环和第三重循环实际上是并列的关系。
 * <p>
 * 有了这样的发现，我们就可以保持第二重循环不变，而将第三重循环变成一个从数组最右端开始向左移动的指针
 */
public class LeetCode15_Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                while (k > j + 1 && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
