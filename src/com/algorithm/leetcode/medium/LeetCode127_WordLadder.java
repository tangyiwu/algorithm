package com.algorithm.leetcode.medium;

import java.util.*;

public class LeetCode127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        queue.add(beginWord);
        String word, tmp;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                word = queue.remove();
                if (endWord.equals(word)) {
                    return level + 1;
                }
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        tmp = new String(chars);
                        if (!tmp.equals(word) && set.contains(tmp)) {
                            queue.add(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode127_WordLadder wordLadder = new LeetCode127_WordLadder();
        String[] a = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        List<String> dict = new ArrayList<>(Arrays.asList(a));
        int level = wordLadder.ladderLength("qa", "sq", dict);
        System.out.println(level);
    }
}
