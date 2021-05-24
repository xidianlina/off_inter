package algorithm;

import java.util.*;

public class StrOrgEnd {
    public static void main(String[] args) {
        String[] str = {"gj", "jl", "dg", "ad", "gg"};
        String[] str2 = {"aes", "dwewe", "ea", "sd"};
        String[] str3 = {"as", "st", "ta", "ar"};
        StrOrgEnd sre = new StrOrgEnd();
        System.out.println(sre.strOrgEnd(str));
        System.out.println(sre.strOrgEnd(str2));
        System.out.println(sre.strOrgEnd(str3));
        System.out.println("------------------");
        sre.strOrgEnd2(str);
    }

    public boolean strOrgEnd(String[] str) {
        //用于保存字符串的首尾字符
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; ++i) {
            char start = str[i].charAt(0);
            char end = str[i].charAt(str[i].length() - 1);
            sb.append(start).append(end);
        }

        char[] chars = sb.toString().toCharArray();
        //用于保存字符出现的个数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            char key = chars[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }

        Collection collection = map.values();
        Iterator<Integer> iter = collection.iterator();
        while (iter.hasNext()) {
            int count = iter.next();
            if (count % 2 != 0) {
                //如果有一个不是出现偶数次,则说明不能组成环
                return false;
            }
        }

        return true;
    }

    public void strOrgEnd2(String[] str) {
        int size = str.length;
        if (size == 0) {
            return;
        }

        strOrgEndhelper(str, 0);
    }

    public void strOrgEndhelper(String[] str, int k) {
        if (k == str.length) {
            System.out.println(Arrays.toString(str));
            return;
        }
        for (int i = k; i < str.length; ++i) {
            /**
             *  交换k+1和i
             *  k=0,表明为第一个字符串，必须和自己以及后面每一个交换
             *  k>0时，假设0-(k-1)是排序好的，需比较k-1和i的顺序
             */
            if ((k > 0 && judge(str[k - 1], str[i])) || k == 0) {
                swap(str, k, i);
                strOrgEndhelper(str, k + 1);
                swap(str, k, i);
            }
        }
    }

    private boolean judge(String str1, String str2) {
        if (str1.charAt(str1.length() - 1) == str2.charAt(0)) {
            return true;
        }
        return false;
    }

    private void swap(String[] str, int i, int j) {
        String tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
