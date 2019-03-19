package com.algorithm.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 把数字翻译成字符串
 * <p>
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Problem46 {

    public List<String> getNumberAllTranslation(int n) {
        Map<String, String> translator = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            translator.put(String.valueOf(i + 1), String.valueOf((char) (i + 'a')));
        }
        List<String> solutions = new ArrayList<>();
        translate("", String.valueOf(n), translator, solutions);
        return solutions;
    }

    private void translate(String translateStr, String leftStr, Map<String, String> translator, List<String> solutions) {
        if (leftStr == null || leftStr.length() == 0) {
            solutions.add(translateStr);
            return;
        }
        if (leftStr.length() == 1) {
            translateStr += translator.getOrDefault(leftStr, leftStr);
            solutions.add(translateStr);
            return;
        }
        if (leftStr.length() == 2) {
            if (translator.containsKey(leftStr)) {
                solutions.add(translateStr + translator.get(leftStr));
            } else {
                translate(translateStr + translator.getOrDefault(leftStr.substring(0, 1), leftStr.substring(0, 1)), leftStr.substring(1), translator, solutions);
            }
            return;
        }
        translate(translateStr + translator.getOrDefault(leftStr.substring(0, 1), leftStr.substring(0, 1)), leftStr.substring(1), translator, solutions);
        if (translator.containsKey(leftStr.substring(0, 2))) {
            translate(translateStr + translator.get(leftStr.substring(0, 2)), leftStr.substring(2), translator, solutions);
        }
    }

    public static void main(String[] args) {
        Problem46 problem46 = new Problem46();
        List<String> solutions = problem46.getNumberAllTranslation(12258);
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
    }
}
