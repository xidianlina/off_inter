# 1.二维数组中的查找
```java
package sword_offer;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例
 * 输入
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * true
 */

public class JZ01 {
    public static void main(String args[]) {
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        JZ01 jz01 = new JZ01();

        boolean res = jz01.Find(target, array);
        System.out.println(res);
    }

    public boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
```
# 2.替换空格
```java
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
```
# 3.从尾到头打印链表
```java

```







