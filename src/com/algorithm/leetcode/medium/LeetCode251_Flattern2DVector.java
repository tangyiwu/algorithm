package com.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode251_Flattern2DVector {
    private static class Vector2D {
        private Queue<Integer> queue;

        public Vector2D(List<List<Integer>> vec2d) {
            queue = new LinkedList<>();
            for (List<Integer> list : vec2d) {
                for (Integer e : list) {
                    queue.add(e);
                }
            }
        }

        public int next() {
            if (hasNext()) {
                return queue.poll();
            }
            return Integer.MAX_VALUE;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        a.add(1);
        a.add(2);
        b.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        vec2d.add(a);
        vec2d.add(b);
        vec2d.add(c);
        Vector2D vector2D = new Vector2D(vec2d);
        while (vector2D.hasNext()) {
            System.out.println(vector2D.next());
        }
    }
}
