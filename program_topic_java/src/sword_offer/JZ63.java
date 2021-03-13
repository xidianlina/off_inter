package sword_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class JZ63 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek() * 1.0;
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek() * 1.0;
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
