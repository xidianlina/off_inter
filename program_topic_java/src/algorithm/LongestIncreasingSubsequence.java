package algorithm;

/*

 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        int[] res = longestIncreasingSubsequence(arr);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] longestIncreasingSubsequence(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return null;
        }

        // 记录当前各元素作为最大元素的最长递增序列长度
        int[] maxLen = new int[size];

        // 记录当前以该元素作为最大元素的递增序列中该元素的前驱节点，用于打印序列用
        int[] pre = new int[size];

        for (int i = 0; i < size; ++i) {
            maxLen[i] = 1;
            pre[i] = i;
        }

        int k = 0;
        int m = 1;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i] && maxLen[j] + 1 > maxLen[i]) {
                    maxLen[i] = maxLen[j] + 1;
                    pre[i] = j;
                }

                if (m < maxLen[i]) {
                    m = maxLen[i];
                    k = i;
                }
            }
        }

        int i = m - 1;
        int[] res = new int[m];
        while (pre[k] != k) {
            res[i--] = arr[k];
            k = pre[k];
        }

        res[i] = arr[k];

        return res;
    }
}
