package com.algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode212_WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> solution = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            if (word != null && word.length() > 0) {
                if (!set.contains(word)) {
                    if (search(word, board)) {
                        solution.add(word);
                    }
                    set.add(word);
                }
            }
        }
        return solution;
    }

    private boolean search(String word, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (searchGraph(i, j, board, 0, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean searchGraph(int i, int j, char[][] board, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (searchGraph(i + 1, j, board, index + 1, word, visited) || searchGraph(i - 1, j, board, index + 1, word, visited)
                || searchGraph(i, j + 1, board, index + 1, word, visited) || searchGraph(i, j - 1, board, index + 1, word, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        LeetCode212_WordSearchII wordSearchII = new LeetCode212_WordSearchII();
        List<String> solution = wordSearchII.findWords(board, words);
        for (String str : solution) {
            System.out.println(str);
        }
    }
}
