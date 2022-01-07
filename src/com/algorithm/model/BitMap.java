package com.algorithm.model;

import com.algorithm.sort.SortUtil;

public class BitMap {
    private int[] bits;

    public BitMap(int capacity) {
        bits = new int[(capacity >> 3) + 1];
    }

    // add 7
    // 7 6 5 4 3 2 1 0
    // 1 0 0 0 0 0 0 0
    public void add(int value) {
        int index = index(value);
        int position = bitPosition(value);
        bits[index] |= (1 << position);
    }

    public void clear(int value) {
        int index = index(value);
        int position = bitPosition(value);
        bits[index] &= ~(1 << position);
    }

    private int index(int value) {
        return value >> 3;
    }

    private int bitPosition(int value) {
        return value & 0x07;
    }

    public boolean contains(int value) {
        int index = index(value);
        int position = bitPosition(value);
        return (bits[index] & (1 << position)) != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(2 << 10);
        int[] nums = SortUtil.getArrayDemo();
        for (int i = 0; i < nums.length; i++) {
            bitMap.add(nums[i]);
        }
        System.out.println("contains 27 " + bitMap.contains(27));
        System.out.println("contains 2  " + bitMap.contains(2));
        bitMap.clear(2);
        System.out.println("contains 27 " + bitMap.contains(2));
    }
}
