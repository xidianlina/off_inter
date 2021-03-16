package algorithm;

import java.util.Random;

/*
Fisher-Yates洗牌算法:
在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
接下来，将当前元素和随机选出的下标所指的元素互相交换。
复杂度分析
时间复杂度:O(n)
Fisher-Yates洗牌算法时间复杂度是线性的，因为算法中生成随机序列，交换两个元素这两种操作都是常数时间复杂度的。
空间复杂度:O(n)
因为要实现重置功能，原始数组必须得保存一份，因此空间复杂度是O(n)。
 */
public class FisherYatesShuffle {
    private int[] array;
    private int[] original;

    //生成随机数
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    //交换数组里的两个元素
    private void swapAt(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public FisherYatesShuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    //将数组重置为其原始配置并返回
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    //返回数组的随机洗牌
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FisherYatesShuffle shuffle = new FisherYatesShuffle(arr);
        shuffle.printArray(arr);
        int[] res = shuffle.shuffle();
        shuffle.printArray(res);
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}