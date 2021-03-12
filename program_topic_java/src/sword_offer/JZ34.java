package sword_offer;

import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入
 * "google"
 * 返回值
 * 4
 */
public class JZ34 {
    public int FirstNotRepeatingChar(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return -1;
        }

        char[] cs = str.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < size; i++) {
            ++hash[cs[i]];
        }

        for (int i = 0; i < size; i++) {
            if (hash[cs[i]] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return -1;
        }

        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (m.containsKey(str.charAt(i))) {
                m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
            } else {
                m.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < size; i++) {
            if (m.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
