package com.algorithm.string;

public class PrintAllStrings {
    public void printAllStrings(char[] strs) {
        if (strs == null || strs.length <= 0) {
            return;
        }
        boolean[] masks = new boolean[strs.length];
        printStrings(strs, masks, "");
    }

    private void printStrings(char[] strs, boolean[] masks, String choice) {
        if (choice.length() == strs.length) {
            System.out.println(choice);
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!masks[i]) {
                masks[i] = true;
                printStrings(strs, masks, choice + strs[i]);
                masks[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PrintAllStrings printAllStrings = new PrintAllStrings();
        char[] strs = {'a', 'b', 'c'};
        printAllStrings.printAllStrings(strs);
    }
}
