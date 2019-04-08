package com.algorithm.leetcode.hard;

import java.util.*;

public class LeetCode126_WordLadder {
    public List<List<String>> findLadders(String b, String e, List<String> w) {
        List<List<String>> res = new ArrayList<>();
        if (e == null || e.equals("") || !w.contains(e)) return res;

        Set<String> set = new HashSet<>(w);
        Set<String> used = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(b);

        int level = 1;
        while (!q.isEmpty() && level < set.size() + 1 && res.size() == 0) {
            int size = q.size();
            List<String> temp = new ArrayList<>(); // use to store used String at this level
            while (size-- > 0) {
                String s = q.poll(); // s = "hit,hot"
                String[] sArr = s.split(","); // sArr = ["hit", "hot"]
                String curr = sArr[sArr.length - 1]; // curr = "hot"
                for (int i = 0; i < curr.length(); i++) {
                    char[] c = curr.toCharArray();
                    for (char l = 'a'; l <= 'z'; l++) {
                        c[i] = l;
                        String t = new String(c);
                        if (t.equals(e)) res.add(Arrays.asList((s + "," + t).split(",")));
                        else if (!t.equals(curr) && set.contains(t) && !used.contains(t)) {
                            q.add(s + "," + t); // put "hit,hot,dot" to queue
                            temp.add(t);
                        }
                    }
                }
            }
            // We should only mark used Strings AFTER searching this whole level, otherwise some word may not find its trans word
            used.addAll(temp);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode126_WordLadder wordLadder = new LeetCode126_WordLadder();
        String[] a = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};
        List<String> dict = new ArrayList<>(Arrays.asList(a));
        List<List<String>> result = wordLadder.findLadders("qa", "sq", dict);
        for (List<String> list : result) {
            for (String word : list) {
                System.out.print(word + ", ");
            }
            System.out.println();
        }
        System.out.println("print" + result.size() + "条数据");
    }
}
