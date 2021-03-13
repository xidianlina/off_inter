package sword_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 示例1
 * 输入
 * 9
 * 返回值
 * [[2,3,4],[4,5]]
 */
public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        if (sum <= 1) {
            return lists;
        }

        int start = 1;
        int end = 2;
        while (start != (1 + sum) / 2) {
            int curSum = (start + end) * (end - start + 1) / 2;
            if (curSum == sum) {
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    res.add(i);
                }
                lists.add(res);
                ++start;
                ++end;
            } else if (curSum > sum) {
                ++start;
            } else {
                ++end;
            }
        }

        return lists;
    }
}
