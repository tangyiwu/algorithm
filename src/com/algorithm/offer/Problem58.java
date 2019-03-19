package com.algorithm.offer;

public class Problem58 {
    public String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i < j) {
            char ic = str.charAt(i);
            char jc = str.charAt(j);
            chars[i] = jc;
            chars[j] = ic;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public String reverseWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        while (str.length() > 0) {
            int end = str.lastIndexOf(" ");
            if (end < 0) {
                result.append(str);
                break;
            }
            result.append(str.substring(end + 1));
            result.append(" ");
            str = str.substring(0, end);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Problem58 problem58 = new Problem58();
        System.out.println(problem58.reverseString("I am a student."));
        System.out.println(problem58.reverseWord("I am a student."));
    }
}
