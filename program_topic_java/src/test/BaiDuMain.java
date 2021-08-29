package test;

import java.util.*;

/*
    在控制台输入字符串，统计每个字符出现的次数，并打印出来
 */
public class BaiDuMain {
    public static void main(String[] args) {
        String str = "abcddesdasda";
        BaiDuMain main = new BaiDuMain();
        main.printString(str);
        System.out.println("-----------------");
        String str2 = "863";
        main.printString(str2);
    }

    public void printString(String str) {
        if (str.isEmpty()) {
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
