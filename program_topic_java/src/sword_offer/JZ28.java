package sword_offer;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 输入
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * 2
 */

public class JZ28 {
    /*
    数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
    因此在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数，当遍历到下一个数字时，如果下一
    个数字和之前保存的数字相同，则次数加1；如果下一个数字和之前保存的数字不同，则次数减1.如果次数为0，
    需要保存下一个数字，并把次数设为1。由于要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么
    要找的数字肯定是最后一次次数设为1时对应的数字。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return 0;
        }

        int num = array[0];
        int cnt = 1;
        for (int i = 1; i < size; i++) {
            if (array[i] == num) {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    num = array[i];
                    cnt = 1;
                }
            }
        }

        cnt = 0;
        for (int i = 0; i < size; i++) {
            if (num == array[i]) {
                ++cnt;
            }
        }

        if (2 * cnt > size) {
            return num;
        } else {
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution2(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return 0;
        }

        int mid = size >> 1;
        int start = 0;
        int end = size - 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = partition(array, start, end);
            } else if (index < mid) {
                start = index + 1;
                index = partition(array, start, end);
            }
        }

        int res = array[mid];
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == res) {
                ++cnt;
            }
        }

        if (2 * cnt > size) {
            return res;
        } else {
            return 0;
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}
