package com.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode401_BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        int[] watch = new int[10];
        readBinaryWatch(list, watch, num, 0);
        return list;
    }

    private void readBinaryWatch(List<String> list, int[] watch, int num, int handled) {
        if (num == handled) {
            String time = readBinaryWatch(watch);
            if (time != null && !list.contains(time)) {
                list.add(time);
            }
        } else {
            for (int i = 0; i < watch.length; i++) {
                if (watch[i] == 0) {
                    watch[i] = 1;
                    readBinaryWatch(list, watch, num, handled + 1);
                    watch[i] = 0;
                }
            }
        }
    }

    private String readBinaryWatch(int[] watch) {
        int hour = 0;
        int minute = 0;
        int hourBase = 1;
        for (int i = 3; i >= 0; i--) {
            hour += watch[i] * hourBase;
            hourBase <<= 1;
        }
        if (hour >= 12) {
            return null;
        }
        int minuteBase = 1;
        for (int i = 9; i >= 4; i--) {
            minute += watch[i] * minuteBase;
            minuteBase <<= 1;
        }
        if (minute >= 60) {
            return null;
        }
        String minuteStr = String.valueOf(minute);
        if (minuteStr.length() == 1) {
            minuteStr = "0" + minuteStr;
        }
        return hour + ":" + minuteStr;
    }

    public static void main(String[] args) {
        LeetCode401_BinaryWatch binaryWatch = new LeetCode401_BinaryWatch();
        binaryWatch.readBinaryWatch(2);
    }
}
