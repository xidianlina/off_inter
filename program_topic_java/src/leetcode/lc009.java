package leetcode;

/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

示例 1：
输入：x = 121
输出：true

示例2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。

示例 4：
输入：x = -101
输出：false

提示：
-2^31<= x <= 2^31- 1
 */
public class lc009 {
    public static void main(String[] args) {
        lc009 lc = new lc009();
        System.out.println(lc.isPalindrome(121));
        System.out.println(lc.isPalindrome(123));
        System.out.println("---------------");
        System.out.println(lc.isPalindrome2(121));
        System.out.println(lc.isPalindrome2(123));
    }

    /*
        第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。
        第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
        但是，如果反转后的数字大于int.MAX，将发生整数溢出问题。
        为了避免数字反转可能导致的溢出问题，只反转数字的一半。如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     */
    public boolean isPalindrome(int x) {
        /*
            特殊情况：
            当 x < 0 时，x 不是回文数。
            如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是0
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }


    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int origin = x;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == origin;
    }
}
