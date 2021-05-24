package algorithm;

public class StringReverse {
    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        String str = stringReverse.reverseString("abcdefg");
        System.out.println(str);
    }

    public String reverseString(String str) {
        int n = str.length();
        if (n == 0 || str.isEmpty()) {
            return str;
        }

        char[] chars = str.toCharArray();
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }

        return new String(chars);
    }
}
