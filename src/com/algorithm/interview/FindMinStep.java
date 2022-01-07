package com.algorithm.interview;

/**
 * a [1,3,9,15,20] target = 12 返回2
 * 找到数据中的子集，子集和大于等于target，返回子集的长度
 */
public class FindMinStep {
    public int find(int[] a, int target) {
        if(a == null || a.length == 0) {
            return 0;
        }
        int p = 0;
        int k = 0;
        int minStep = a.length + 1;
        int sum = 0;
        while (p < a.length) {
            if (sum < target) {
                if(p+k > a.length-1) {
                    break;
                }
                sum += a[p+k];
                k++;
            } else {
                boolean moved = false;
                while (p+1 <= p+k && sum - a[p] >= target) {
                    sum -= a[p++];
                    k--;
                    moved = true;
                }
                if(k < minStep && sum >= target) {
                    minStep = k;
                }
                if (minStep == 1) {
                    return 1;
                }
                if (!moved) {
                    sum -= a[p++];
                    k--;
                }
            }
        }
        if(minStep > a.length) {
            minStep = 0;
        }
        return minStep;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,11};
        FindMinStep minStep = new FindMinStep();
        System.out.println(minStep.find(a, 36));
    }
}
