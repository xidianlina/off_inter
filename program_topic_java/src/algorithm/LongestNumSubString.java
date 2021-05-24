package algorithm;

public class LongestNumSubString {
    public static void main(String[] args) {
        String str = "ad3299adfa3239028903afd";
        System.out.println(longestNumSubString(str));
    }

    public static int longestNumSubString(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return 0;
        }

        int cnt = 0;
        int num = 0;
        for (int i = 0; i < size; ++i) {
            if (isNumber(str.charAt(i))) {
                ++cnt;
                if (cnt > num) {
                    num = cnt;
                }
            } else {
                cnt = 0;
            }
        }

        return num;
    }

    public static boolean isNumber(char c) {
        int n = c - 48;
        if (n >= 0 && n <= 9) {
            return true;
        }

        return false;
    }
}
