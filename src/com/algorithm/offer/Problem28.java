package com.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的排列
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 * <p>
 * 思路：将问题拆分，例如abc，如果知道ab排列组合，将c插入ab排列组合的不同位置，即可得到解
 * solution(A1, A2, ..., An) = insert(solution(A1, A2, ..., An-1), An)
 */
public class Problem28 {
    public List<String> findStringCombination(String source) {
        if (source == null || source.length() <= 0) {
            return null;
        }
        List<String> solution = new ArrayList<>();
        if (source.length() == 1) {
            solution.add(source);
        } else {
            List<String> subSolution = findStringCombination(source.substring(0, source.length() - 1));
            char lastChar = source.charAt(source.length() - 1);
            insertChar(subSolution, lastChar, solution);
        }
        return solution;
    }

    public void insertChar(List<String> subSolution, char lastChar, List<String> solution) {
        for (int i = 0; i < subSolution.size(); i++) {
            String subString = subSolution.get(i);
            for (int j = 0; j < subString.length(); j++) {
                solution.add(subString.substring(0, j) + lastChar + subString.substring(j));
            }
            solution.add(subString + lastChar);
        }
    }

    public static void main(String[] args) {
        Problem28 problem28 = new Problem28();
        List<String> solution = problem28.findStringCombination("abc");

        System.out.println(String.format("字符串有%d中排列", solution.size()));
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i));
        }
    }
}
