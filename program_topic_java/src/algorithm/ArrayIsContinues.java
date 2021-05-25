package algorithm;

/*
如何判断一个数组中的数值是否连续相邻
一个整数数组，元素取值可能是0~65535中的任意一个数，相同数值不会重复出现；0是例外，可以反复出现。
设计一个算法，判断这个数组中的元素是否连续相邻。
需要注意以下4点：
（1）数值允许是乱序的，如 8 7 5 0 6。
（2）0可以通配任意数值，如8 7 5 0 6中的0可以通配成9或者4.
（3）0可以多次出现。
（4）全0算连续，只有一个非0算连续。
分析：如果没有0的存在，要组成连续的数列，最大值和最小值的差距必须是n-1；存在0的情况下，
只要最大值可最小值的差距小于n-1就可以了，缺失的数值可以用0通配。所以找出数列中非0的最大值和非0的最小值，
时间复杂度为O(n)。如果非0最大-非0最小+1<n，即非0最大-非0最小<=n-1，则这n个数值连续相邻。否则，不连续相邻。
因此，总体复杂度为O(n)。
 */
public class ArrayIsContinues {
    public static void main(String[] args) {
        ArrayIsContinues isContinues = new ArrayIsContinues();
        int[] arr = {8, 7, 5, 0, 6, 10, 12};
        System.out.println(isContinues.arrayIsContinues(arr));
    }

    public boolean arrayIsContinues(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return true;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i) {
            if (arr[i] != 0) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        return (max - min) <= (size - 1) ? true : false;
    }
}
