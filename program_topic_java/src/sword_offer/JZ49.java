package sword_offer;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 返回值描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * "+2147483647"
 * 返回值
 * 2147483647
 * 示例2
 * 输入
 * "1a33"
 * 返回值
 * 0
 */
public class JZ49 {
    public int StrToInt(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return 0;
        }

        int sum = 0;
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) == '+') {
            sign = 1;
        } else if (str.charAt(0) >= '1' && str.charAt(0) <= '9') {
            sum = str.charAt(0) - '0';
        } else {
            return 0;
        }

        for (int i = 1; i < size; i++) {
            if (str.charAt(i) < '1' || str.charAt(i) > '9') {
                return 0;
            }
            sum = sum * 10 + str.charAt(i) - '0';
        }

        return sum * sign;
    }
}
