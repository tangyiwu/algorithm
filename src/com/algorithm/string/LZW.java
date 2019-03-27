package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LZW {
    public String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int symbol = 0;
        for (char c : str.toCharArray()) {
            if (!map.containsKey(String.valueOf(c))) {
                map.put(String.valueOf(c), symbol++);
                sb.append(c);
            }
        }
        sb.append(';');
        String p = "";
        for (char c : str.toCharArray()) {
            String pc = p + c;
            if (!map.containsKey(pc)) {
                sb.append(map.get(p));
                map.put(pc, symbol++);
                p = String.valueOf(c);
            } else {
                p = pc;
            }
        }
        sb.append(map.get(p));
        return sb.toString();
    }

    public String decompress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        Map<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int symbol = 0;
        while (str.charAt(symbol) != ';') {
            map.put(symbol, String.valueOf(str.charAt(symbol)));
            symbol++;
        }
        str = str.substring(symbol + 1);
        int cw = 0;
        sb.append(map.get(cw));
        int pw = cw;
        String P = "";
        String C = "";
        for (int i = 1; i < str.length(); i++) {
            cw = str.charAt(i) - '0';
            if (map.containsKey(cw)) { // cw在字典里
                sb.append(map.get(cw));
                P = map.get(pw);
                C = map.get(cw).substring(0, 1);
                map.put(symbol++, P + C);
            } else {
                P = map.get(pw);
                C = map.get(pw).substring(0, 1);
                map.put(cw, P + C);
                sb.append(P).append(C);
            }
            pw = cw;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LZW lzw = new LZW();
        String str = "ababcababac";
        String compress = lzw.compress(str);
        System.out.println(compress);
        System.out.println(lzw.decompress(compress));
    }
}
