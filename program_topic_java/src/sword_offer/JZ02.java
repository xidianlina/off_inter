package sword_offer;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 示例
 * 输入
 * "We Are Happy"
 * 返回值
 * "We%20Are%20Happy"
 */
public class JZ02 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        String replaceStr = "%20";
        for (char c : charArr) {
            if (c == ' ') {
                sb.append(replaceStr);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        char[] charArr = s.toCharArray();
        int replaceLength = 0;
        for (char c : charArr) {
            if (c == ' ') {
                replaceLength++;
            }
        }

        char[] resultArr = new char[charArr.length + 2 * replaceLength];
        int oldLength = charArr.length - 1;
        int newLength = resultArr.length - 1;
        while (newLength >= 0) {
            if (charArr[oldLength] == ' ') {
                resultArr[newLength--] = '0';
                resultArr[newLength--] = '2';
                resultArr[newLength--] = '%';
            } else {
                resultArr[newLength--] = charArr[oldLength];
            }
            oldLength--;
        }
        return String.valueOf(resultArr);
    }
}
