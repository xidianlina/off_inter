package com.test.demo;

import java.util.HashMap;
import java.util.Map;

//字符串“2223333355"找出出现最多的数字 输出数字和个数
public class DidiDemo {
    public static void main(String[] args) {
        String str = "2223333355";
        getResult(str);
    }

    public static void getResult(String str) {
        if (str.isEmpty()) {
            return;
        }

        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        char res = ch[0];
        for (int i = 0; i < ch.length; ++i) {
            if (map.containsKey(ch[i])) {
                if (count < map.get(ch[i]) + 1) {
                    count = map.get(ch[i]) + 1;
                    res = ch[i];
                }
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }
        }

        System.out.println("res: " + res + " count: " + count);
    }
}
