package algorithm;

public class MoveArrayReverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        MoveArrayReverse mr = new MoveArrayReverse();
        mr.printArray(arr);
        mr.moveArrayReverse(arr, 3);
        mr.printArray(arr);
    }

    public void moveArrayReverse(int[] arr, int n) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int m = size - n;
        reverse(arr, 0, m - 1);
        reverse(arr, m, size - 1);
        reverse(arr, 0, size - 1);
    }

    public void reverse(int[] arr, int i, int j) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int tmp = 0;
        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
