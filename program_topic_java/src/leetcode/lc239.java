package leetcode;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
import java.util.Deque;
import java.util.LinkedList;
public class lc239 {
    /**
     * 由于需要求出的是滑动窗口的最大值，如果当前的滑动窗口中有两个下标 i 和 j，其中 i 在 j 的左侧（i<j），
     * 并且 i 对应的元素不大于 j 对应的元素（nums[i]≤nums[j]），那么会发生什么呢？
     * 当滑动窗口向右移动时，只要 i 还在窗口中，那么 j 一定也还在窗口中，这是 i 在 j 的左侧所保证的。
     * 因此，由于 nums[j] 的存在，nums[i] 一定不会是滑动窗口中的最大值了，可以将 nums[i] 永久地移除。
     *
     * 因此可以使用一个队列存储所有还没有被移除的下标。在队列中，这些下标按照从小到大的顺序被存储，
     * 并且它们在数组 nums 中对应的值是严格单调递减的。因为如果队列中有两个相邻的下标，它们对应的值相等或者递增，
     * 那么令前者为 i，后者为 j，就对应了上面所说的情况，即 nums[i] 会被移除，这就产生了矛盾。
     *
     * 当滑动窗口向右移动时，需要把一个新的元素放入队列中。为了保持队列的性质，会不断地将新的元素与队尾的元素相比较，
     * 如果前者大于等于后者，那么队尾的元素就可以被永久地移除，将其弹出队列。
     * 需要不断地进行此项操作，直到队列为空或者新的元素小于队尾的元素。
     *
     * 由于队列中下标对应的元素是严格单调递减的，因此此时队首下标对应的元素就是滑动窗口中的最大值。
     * 此时的最大值可能在滑动窗口左边界的左侧，并且随着窗口向右移动，它永远不可能出现在滑动窗口中了。
     * 因此还需要不断从队首弹出元素，直到队首元素在窗口中为止。
     *
     * 为了可以同时弹出队首和队尾的元素，需要使用双端队列。
     *
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次，因此时间复杂度为 O(n)。
     * 空间复杂度：O(k)。使用的数据结构是双向的，因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1 个元素，因此队列使用的空间为 O(k)。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
