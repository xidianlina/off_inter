package sword_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 示例1
 * 输入
 * [1,4,1,6]
 * 返回值
 * [4,6]
 * 说明
 * 返回的结果中较小的数排在前面
 */
public class JZ40 {
    public int[] FindNumsAppearOnce(int[] array) {
        int size = array.length;
        int[] res = new int[2];
        if (array == null || size < 2) {
            return res;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum ^= array[i];
        }

        int n = 1;
        if ((sum & n) == 0) {
            n <<= 1;
        }

        for (int i = 0; i < size; i++) {
            if ((array[i] & n) != 0) {
                res[0] ^= array[i];
            } else {
                res[1] ^= array[i];
            }
        }

        Arrays.sort(res);
        return res;
    }

    public int[] FindNumsAppearOnce2(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            //检索是否存在这一个数字
            int flag = list.indexOf(array[i]);
            if (flag == -1) {
                //不存在则添加
                list.add(array[i]);
            } else {
                //存在则删除
                list.remove(flag);
            }
        }

        //最后剩下两个即是只出现一次的
        return new int[]{list.get(0), list.get(1)};
    }

    public int[] FindNumsAppearOnce3(int[] array) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : array) {
            int times = m.getOrDefault(n, 0);
            times++;
            m.put(n, times);
        }

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                res[index] = entry.getKey();
                index++;
            }
        }

        return res;
    }
}
