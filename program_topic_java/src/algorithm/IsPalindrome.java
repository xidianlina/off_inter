package algorithm;

public class IsPalindrome {
    public static void main(String[] args) {
        String str = "abceda";
        String str2 = "";
        String str3 = "abdba";
        boolean flag = isPalindrome(str3);
        System.out.println(flag);
    }

    public static boolean isPalindrome(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return false;
        }
        int i = 0;
        while (i < size / 2) {
            if (str.charAt(i) != str.charAt(size - i - 1)) {
                return false;
            }
            ++i;
        }

        return true;
    }
}
