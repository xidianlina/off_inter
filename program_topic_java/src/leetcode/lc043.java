package leetcode;

/*
给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"

说明：
num1和num2的长度小于110。
num1 和num2 只包含数字0-9。
num1 和num2均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class lc043 {
    /*
        如果num1和num2之一是0，则直接将0作为结果返回即可。如果num1和num2都不是0，则可以通过模拟「竖式乘法」的方法计算乘积。
        从右往左遍历乘数，将乘数的每一位与被乘数相乘得到对应的结果，再将每次得到的结果累加。这道题中，被乘数是num1，乘数是num2。
        需要注意的是num2除了最低位以外，其余的每一位的运算结果都需要补0。
        由于num1和num2的乘积的最大长度为m+n，因此创建长度为m+n的数组result用于存储乘积。对于任意0≤i<m 和0≤j<n，
        num1[i]×num2[j]的结果位于result[i+j+1]，如果result[i+j+1]≥10，则将进位部分加到result[i+j]。
        最后，将数组result转成字符串，如果最高位是0则舍弃最高位。

        时间复杂度:O(mn)，其中m和n分别是num1和num2的长度。需要计算num1的每一位和num2的每一位的乘积。
        空间复杂度:O(m+n)，其中m和n分别是num1和num2的长度。需要创建一个长度为m+n的数组存储乘积。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                int y = num2.charAt(j) - '0';
                result[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; --i) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }

        int index = result[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(result[index]);
            ++index;
        }

        return ans.toString();
    }
}
