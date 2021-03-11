package sword_offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * 示例1
 * 输入
 * [4,5,1,6,2,7,3,8],4
 * 返回值
 * [1,2,3,4]
 */
public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int size = input.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || input == null || size < k || k <= 0) {
            return res;
        }

        int start = 0;
        int end = size - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else if (index < k - 1) {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
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

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        int size = input.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || input == null || size < k || k <= 0) {
            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < size; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else {
                if (maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }

        for (Integer num : maxHeap) {
            res.add(num);
        }

        return res;
    }
}
