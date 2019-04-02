package com.algorithm.string;

public class ReverseString {
    public String reverseStr(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            swap(chars, i, j);
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public String reverseWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] chars = str.toCharArray();
        int start = -1;
        int end = -1;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur != ' ') {
                if (start < 0) {
                    start = i;
                    end = start;
                } else {
                    end++;
                }
            } else {
                if (end >= 0) {
                    reverse(chars, start, end);
                }
                start = -1;
                end = -1;
            }
        }
        if (end >= 0) {
            reverse(chars, start, end);
            start = -1;
            end = -1;
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start <= end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String str = "hello world";
        System.out.println(reverseString.reverseStr(str));
        System.out.println(reverseString.reverseWord("abc  def ghi "));
    }
}
