package leetcode;

/**
 * 超市正在促销，你可以用numExchange个空水瓶从超市兑换一瓶水。最开始，你一共购入了numBottles瓶水。
 * 如果喝掉了水瓶中的水，那么水瓶就会变成空的。
 * 给你两个整数 numBottles 和 numExchange ，返回你 最多 可以喝到多少瓶水。
 *
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶水。
 *
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空瓶兑换 1 瓶水。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶水。
 *
 * 提示：
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 */
public class lc1518 {
    /*
    时间复杂度：O(b/e)
    空间复杂度：O(1)
    */
    public int numWaterBottles(int b, int e) {
        if (b < e) {
            return b;
        }
        int ans = b;
        while (b >= e) {
            int f = b / e;
            int g = b % e;
            ans += f;
            b = f + g;
        }
        return ans;
    }

    public int numWaterBottles2(int b, int e) {
        if (b < e) {
            return b;
        }
        int ans = b;
        while (b >= e) {
            b -= e;
            ans++;
            b++;
        }
        return ans;
    }
}
