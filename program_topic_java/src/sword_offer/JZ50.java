package sword_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是第一个重复的数字2。没有重复的数字返回-1。
 * 示例1
 * 输入
 * [2,3,1,0,2,5,3]
 * 返回值
 * 2
 */
public class JZ50 {
    public int duplicate(int[] array) {
        int size = array.length;
        if (size < 1 || array == null) {
            return -1;
        }

        int[] hash = new int[size];
        for (int num : array) {
            ++hash[num];
            if (hash[num] > 1) {
                return num;
            }
        }

        return -1;
    }

    public int duplicate2(int[] array) {
        int size = array.length;
        if (size < 1 || array == null) {
            return -1;
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int num : array) {
            if (m.containsKey(num)) {
                return num;
            }
            m.put(num, 1);
        }

        return -1;
    }
}
