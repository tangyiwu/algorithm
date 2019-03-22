package com.algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class LeetCode68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> solution = new ArrayList<>();
        int p = 0;
        while (p < words.length) {
            int start = p;
            int count = 0;
            int length = 0;
            for (int i = start; i < words.length; i++) {
                if (i == start) {
                    length += words[i].length();
                    count++;
                    continue;
                } else if (length + 1 + words[i].length() <= maxWidth) {
                    length += 1;
                    length += words[i].length();
                    count++;
                    continue;
                }
                break;
            }
            String line = getLine(words, maxWidth, start, count);
            if (line.length() > 0) {
                solution.add(line);
            }
            p = start + count;
        }
        return solution;
    }

    private String getLine(String[] words, int maxWidth, int start, int count) {
        StringBuilder sb = new StringBuilder();
        if (count == 1) { // line has only one word
            sb.append(words[start]);
            if (sb.length() < maxWidth) {
                sb.append(getSpaceString(maxWidth - sb.length()));
            }
            return sb.toString();
        } else if (count > 1) {
            if (start + count >= words.length) { // last line
                sb.append(words[start]);
                for (int i = start + 1; i < start + count; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                if (sb.length() < maxWidth) {
                    sb.append(getSpaceString(maxWidth - sb.length()));
                }
            } else {
                int[] spaceGroups = new int[count - 1];
                int chs = 0;
                for (int i = start; i < start + count; i++) {
                    chs += words[i].length();
                }
                int spaces = maxWidth - chs;
                for (int i = 0; i < spaces; i++) {
                    spaceGroups[i % spaceGroups.length]++;
                }
                sb.append(words[start]);
                int spaceIndex = 0;
                for (int i = start + 1; i < start + count; i++) {
                    sb.append(getSpaceString(spaceGroups[spaceIndex++]));
                    sb.append(words[i]);
                }
            }
        }
        return sb.toString();
    }

    private String getSpaceString(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode68_TextJustification textJustification = new LeetCode68_TextJustification();
        String[] a = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> solution = textJustification.fullJustify(a, 16);
        System.out.println("=========test a===========");
        for (String str : solution) {
            System.out.println(str);
        }

        String[] b = {"What", "must", "be", "acknowledgment", "shall", "be"};
        solution = textJustification.fullJustify(b, 16);
        System.out.println("=========test b===========");
        for (String str : solution) {
            System.out.println(str);
        }

        String[] c = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        solution = textJustification.fullJustify(c, 20);
        System.out.println("=========test c===========");
        for (String str : solution) {
            System.out.println(str);
        }
    }
}
