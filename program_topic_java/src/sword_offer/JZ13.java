package sword_offer;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 示例
 * 输入
 * [1,2,3,4]
 * 返回值
 * [1,3,2,4]
 */
public class JZ13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        JZ13 jz13 = new JZ13();
        jz13.printArray(arr);
        jz13.reOrderArray(arr);
        jz13.printArray(arr);
        System.out.println("-----------------");
        int[] arr2 = {1, 2, 3, 4, 5};
        jz13.printArray(arr2);
        jz13.reOrderArray2(arr2);
        jz13.printArray(arr2);
    }

    public int[] reOrderArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return new int[]{};
        }
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                    array[j] = array[j] + array[j - 1];
                    array[j - 1] = array[j] - array[j - 1];
                    array[j] = array[j] - array[j - 1];
                }
            }
        }
        return array;
    }

    public int[] reOrderArray2(int[] array) {
        int len = array.length;
        if (len == 0) {
            return new int[]{};
        }
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < len && array[i] % 2 == 1) {
                i++;
            }
            j = i + 1;
            while (j < len && array[j] % 2 == 0) {
                j++;
            }
            if (j < len) {
                int tmp = array[j];
                for (int k = j - 1; k >= i; k--) {
                    array[k + 1] = array[k];
                }
                array[i] = tmp;
            } else {
                break;
            }
        }
        return array;
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0) {
            return;
        }

        for (int i = 0; i < size - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
