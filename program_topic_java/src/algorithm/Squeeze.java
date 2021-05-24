package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Squeeze {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(squeeze(str1, str2));
        System.out.println(squeeze2(str1, str2));
    }

    private static String squeeze(String str1, String str2) {
        int i = 0, j = 0;
        StringBuilder sb = null;
        while (j < str2.length()) {
            sb = new StringBuilder();
            while (i < str1.length()) {
                if (str1.charAt(i) != str2.charAt(j)) {
                    sb.append(str1.charAt(i));
                }
                ++i;
            }
            str1 = new String(sb);
            i = 0;
            ++j;
        }
        return str1;
    }

    private static String squeeze2(String str1, String str2) {
        Map<Character, Boolean> m = new HashMap<>();

        for (int i = 0; i < str2.length(); ++i) {
            if (!m.containsKey(str2.charAt(i))) {
                m.put(str2.charAt(i), true);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); ++i) {
            if (!m.containsKey(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }

        return new String(sb);
    }
}
