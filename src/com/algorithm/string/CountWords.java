package com.algorithm.string;

import java.util.*;

public class CountWords {
    public void count(String str) {
        int start = -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur != ' ') {
                if (start < 0) {
                    start = i;
                }
            } else {
                if (start >= 0) {
                    String word = str.substring(start, i);
                    start = -1;
                    if (map.containsKey(word)) {
                        int preCount = map.get(word);
                        map.put(word, preCount + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
        }
        if (start >= 0) {
            String word = str.substring(start);
            if (map.containsKey(word)) {
                int preCount = map.get(word);
                map.put(word, preCount + 1);
            } else {
                map.put(word, 1);
            }
        }
        WordBean[] wordBeans = new WordBean[map.size()];
        Iterator<String> iterator = map.keySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String word = iterator.next();
            int count = map.get(word);
            wordBeans[i++] = new WordBean(word, count);
        }
        Arrays.sort(wordBeans, (o1, o2) -> o2.count - o1.count);
        for (int j = 0; j < wordBeans.length; j++) {
            System.out.println(wordBeans[j].word + " " + wordBeans[j].count);
        }
    }

    private static class WordBean {
        String word;
        int count;

        public WordBean(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String str = "apple bird bird apple cat bird apple dog apple cat";
        CountWords countWords = new CountWords();
        countWords.count(str);
    }
}
