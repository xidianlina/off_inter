package algorithm;

/*
正整数序列Q中的每个元素都至少能被正整数a和b中的一个整除，现给定a和b，如何计算出Q中的前N项？
例如，当 a=3，b=5，N=6时，序列为3，5，6，9，10，12。

分析：可以和归并排序联系起来，给定两个数组 A、B，数组 A 存放：3 x 1，3 x 2，3 x 3，…
数组 B 存放 5 x 1，5 x 2，5 x 3，… 有两个指针 i、j，分别指向 A、B 的第一个元素，取 Min(A[ i ], B[ j ])，
并将较小值的指针前移，然后继续比较（即归并排序中的“合并两个有序序列“）。
当然，实现时没有必要申请两个数组，用两个变量即可
 */
public class CreateQArray {
    public static void main(String[] args) {
        CreateQArray createArray = new CreateQArray();
        int[] res = createArray.createArray(3, 5, 6);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + "\t");
        }
    }

    public int[] createArray(int a, int b, int n) {
        int[] res = new int[n];
        if (n <= 0) {
            return null;
        }

        int i = 1, j = 1;
        int k = 0;
        while (k < n) {
            if (i * a < j * b) {
                res[k++] = i * a;
                ++i;
            } else {
                res[k++] = j * b;
                ++j;
            }
        }

        return res;
    }
}
