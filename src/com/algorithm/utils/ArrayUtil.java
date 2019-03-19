package com.algorithm.utils;

public class ArrayUtil {
    public static void printArray(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i : a) {
            sb.append(i).append(',');
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
        System.out.println(sb.toString());
    }
}
