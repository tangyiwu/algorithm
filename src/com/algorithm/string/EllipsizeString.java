package com.algorithm.string;

public class EllipsizeString {
    public static enum Ellipsize {
        START,
        MIDDLE,
        END
    }

    public static String ellipsize(String input, int w, String suffix, Ellipsize ellipsize) {
        if (suffix == null) {
            throw new IllegalArgumentException("illegal argument: " + suffix);
        }
        if (input == null || input.isEmpty()) {
            return input;
        }
        if (input.length() <= w) {
            return input;
        }
        if (w < suffix.length()) {
            return input.substring(0, w);
        }
        if (ellipsize == Ellipsize.START) {
            return start(input, w, suffix);
        } else if (ellipsize == Ellipsize.MIDDLE) {
            return mid(input, w, suffix);
        } else {
            return end(input, w, suffix);
        }
    }

    private static String start(String input, int w, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(suffix);
        int len = input.length();
        sb.append(input.substring(len - w + 3, len));
        return sb.toString();
    }

    private static String mid(String input, int w, String suffix) {
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        int showLen = w - suffix.length();
        sb.append(input.substring(0, showLen / 2));
        sb.append(suffix);
        sb.append(input.substring(len - showLen / 2, len));
        return sb.toString();
    }

    private static String end(String input, int w, String suffix) {
        StringBuilder sb = new StringBuilder(input.substring(0, w - suffix.length()));
        sb.append(suffix);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hello, world";
        System.out.println(ellipsize(str, 7, "...", Ellipsize.START));
        System.out.println(ellipsize(str, 7, "...", Ellipsize.MIDDLE));
        System.out.println(ellipsize(str, 7, "...", Ellipsize.END));
    }
}
