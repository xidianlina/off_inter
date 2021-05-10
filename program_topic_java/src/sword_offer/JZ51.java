package sword_offer;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 示例1
 * 输入
 * [1,2,3,4,5]
 * 返回值
 * [120,60,40,30,24]
 */
public class JZ51 {
    public int[] multiply(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return null;
        }

        int[] res = new int[size];
        res[0] = 1;
        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * array[i - 1];
        }

        int tmp = 1;
        for (int i = size - 2; i >= 0; i--) {
            tmp *= array[i + 1];
            res[i] *= tmp;
        }

        return res;
    }
}
