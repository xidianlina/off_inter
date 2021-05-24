package algorithm;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 5, 0, 3, 6, 8};
        longestContinuousIncreasingSubsequence(arr);
    }

    public static void longestContinuousIncreasingSubsequence(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int curLen = 1;
        int maxLen = 1;
        int index = 0;
        for (int i = 1; i < size; ++i) {
            if (arr[i] > arr[i - 1]) {
                ++curLen;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    index = i;
                }
            } else {
                curLen = 1;
            }
        }

        int i = index - maxLen + 1;
        while (maxLen != 0) {
            System.out.print(arr[i] + "\t");
            ++i;
            maxLen--;
        }
    }
}
