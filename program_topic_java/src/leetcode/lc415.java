package leetcode;

/*
415. 字符串相加
给定两个字符串形式的非负整数num1 和num2，计算它们的和。

提示：
num1 和num2的长度都小于 5100
num1 和num2 都只包含数字0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 */
public class lc415 {
    /*
        时间复杂度：O(max(len1,len2))，其中len1=num 1.length，len2=num2.length。竖式加法的次数取决于较大数的位数。
        空间复杂度：O(1)
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            ans.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }

        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
