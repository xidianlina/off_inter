package leetcode;

/**
 *  给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次。
 *  请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
import java.util.HashMap;
import java.util.Map;
public class lc137 {
    /**
     * 时间复杂度：O(n)，其中 n 是数组的长度。
     * 空间复杂度：O(n)。哈希映射中包含最多 [n/3]+1 个元素，即需要的空间为 O(n)。
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();

            if (cnt == 1) {
                res = num;
                break;
            }
        }

        return res;
    }

    /**
     * 位运算:
     * 将数的二进制位每一位相加，然后对其每一位的和取余
     * 如果其他数都出现 3 次，只有目标数出现 1 次，那么每一位的 1 的个数无非有这2种情况，
     * 为 3 的倍数（全为出现三次的数） 或 3 的倍数 +1（包含出现一次的数）。这个 3 的倍数 +1 的情况也就是目标数的那一位。
     *
     * 因为 a & 1 中 1 只有最后一位为 1，其余位皆为 0 ，
     * 所以 a & 1的作用就是判断 a 的最后一位是否为 1 ，如果 a 的最后一位为 1 ，a & 1 = 1,否则为 0 。
     * 所以这个公式来判断 a 的奇偶性。
     *
     * & 按位与运算符：参与运算的两个值,如果两个相应位都为1,则该位的结果为1,否则为0
     * | 按位或运算符：只要对应的二个二进位有一个为1时，结果位就为1
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            int sum = 0;
            for (int num : nums) {
                int temp = num >> i & 1;
                if (temp == 1) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                res = res | 1 << i;
            }
        }
        return res;
    }
}
