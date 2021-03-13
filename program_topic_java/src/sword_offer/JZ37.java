package sword_offer;

/**
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入
 * [1,2,3,3,3,3,4,5],3
 * 返回值
 * 4
 */
public class JZ37 {
    public int GetNumberOfK(int[] array, int k) {
        int size = array.length;
        if (size == 0 || array == null) {
            return 0;
        }

        int index = 0, low = 0, high = size - 1, mid = 0;
        while (low < high) {
            mid = (low + high) >> 1;
            if (array[mid] == k) {
                index = mid;
                break;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int cnt = 0;
        for (int i = index; i < size; i++) {
            if (array[i] == k) {
                cnt++;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            if (array[i] == k) {
                cnt++;
            }
        }

        return cnt;
    }
}
