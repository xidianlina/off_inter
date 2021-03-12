package sword_offer;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 对于50%的数据,size≤10
 * 对于75%的数据,size≤10
 * 对于100%的数据,size≤2∗10
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入
 * [1,2,3,4,5,6,7,0]
 * 返回值
 * 7
 */
public class JZ35 {
    static int pairNum;

    public int InversePairs(int[] array) {
        pairNum = 0;
        int size = array.length;

        if (array != null) {
            mergeSort(array, 0, size - 1);
        }
        return pairNum;
    }

    private void mergeSort(int[] array, int start, int end) {
        int mid = (start + end) >> 1;
        if (start < end) {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            mergeHelper(array, start, mid, end);
        }
    }

    private void mergeHelper(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                pairNum += mid - i + 1;
                if (pairNum > 1000000007) {
                    pairNum %= 1000000007;
                }
            }
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        for (int m = 0; m < tmp.length; i++) {
            array[m + left] = tmp[m];
        }
    }
}
