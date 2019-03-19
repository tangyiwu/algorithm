package com.algorithm.string;

/**
 * "abc  def   ghi" => "Abc Def Ghi"
 */
public class TrimBlankSpaceInStr {
    public void trimCharArray(char[] strs) {
        if (strs == null) {
            return;
        }
        int cur = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != ' ') {
                if (cur == 0 || strs[cur - 1] == ' ') {
                    strs[cur++] = Character.toUpperCase(strs[i]);
                } else {
                    strs[cur++] = strs[i];
                }
            } else {
                if (cur > 0 && strs[cur - 1] != ' ') {
                    strs[cur++] = strs[i];
                }
            }
        }
        for (int i = cur; i < strs.length; i++) {
            strs[i] = ' ';
        }
    }

    public static void main(String[] args) {
        String strs = "abc  def   ghi";
        TrimBlankSpaceInStr demo = new TrimBlankSpaceInStr();
        char[] chars = strs.toCharArray();
        demo.trimCharArray(chars);
        System.out.println(String.valueOf(chars));
    }
}
