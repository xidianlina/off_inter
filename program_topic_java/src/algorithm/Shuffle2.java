package algorithm;

public class Shuffle2 {
    public static void main(String[] args) {
        Shuffle2 shuffle = new Shuffle2();
        int[] arr = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        shuffle.printArray(arr);
        shuffle.shuffle(arr);
        shuffle.printArray(arr);
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }

    public void shuffle(int[] arr) {
        int l = arr.length;
        if (l < 3 || l % 2 == 1) {
            return;
        }

        int n = l / 2;
        int left = n - 1;
        int right = n;
        //交换次数
        for (int i = 0; i < n - 1; i++) {
            for (int j = left; j < right; j += 2) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
            --left;
            ++right;
        }
    }
}
