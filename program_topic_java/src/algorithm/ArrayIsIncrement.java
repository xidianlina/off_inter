package algorithm;

public class ArrayIsIncrement {
    public static void main(String[] args) {
        ArrayIsIncrement main = new ArrayIsIncrement();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(main.arrayIsIncrement(arr, arr.length));
        int[] ar = {0, 9, 4};
        System.out.println(main.arrayIsIncrement(ar, ar.length));
    }

    public boolean arrayIsIncrement(int[] arr, int size) {
        if (size == 1) {
            return true;
        }

        return arr[size - 1] >= arr[size - 2] && arrayIsIncrement(arr, size - 1);
    }
}
