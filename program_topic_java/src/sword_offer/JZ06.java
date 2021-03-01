package sword_offer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * [3,4,5,1,2]
 * 返回值
 * 1
 */
public class JZ06 {
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0 || array == null) {
            return -1;
        }

        int low = 0;
        int high = len - 1;
        int mid = 0;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = (low + high) >> 1;
            if (array[low] == array[high] && array[low] == array[mid]) {
                int res = array[low];
                for (int i = low + 1; i <= high; i++) {
                    if (array[i] < res) {
                        res = array[i];
                    }
                }
                return res;
            }
            if (array[mid] >= array[high]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }
}
