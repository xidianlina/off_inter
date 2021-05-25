package algorithm;

/*
找出数组中出现奇数次的元素：有一个整数数组arr，其中的元素只有一个元素出现奇数次，请找出这个元素。
对于任意一个数k，有k^k = 0，k^0 = k，所以将arr中所有元素进行异或，那么出现次数为偶数的元素异或后都变成了0，出现次数为奇数的元素异或后得到元素本身。
 */
public class OddElement {
    public static void main(String[] args) {
        OddElement oe = new OddElement();
        int[] arr = {1, 2, 3, 4, 2, 1, 4, 3, 2};
        int res = oe.oddElement(arr);
        System.out.println(res);
    }

    public int oddElement(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            res ^= arr[i];
        }

        return res;
    }
}
