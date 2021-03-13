package sword_offer;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 示例1
 * 输入
 * "123.45e+6"
 * 返回值
 * true
 * 示例2
 * 输入
 * "1.2.3"
 * 返回值
 * false
 */
public class JZ53 {
    public boolean isNumeric(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return true;
        }

        boolean hasE = false, sign = false, decimal = false;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                if (i == size - 1 || hasE) {
                    return false;
                }
                hasE = true;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (sign && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') {
                    return false;
                }
                if (!sign && i > 0 && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') {
                    return false;
                }
                sign = true;
            } else if (str.charAt(i) == '.') {
                if (hasE) {
                    return false;
                }
                if (decimal) {
                    return false;
                }
                decimal = true;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }
}
