package algorithm;

public class Shuffle {
    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
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

        int size = l / 2;
        int index = 0;
        int count = 0;
        for (int i = size; i < l - 1; i++) {
            //交换个数
            count = size - (i - size) - 1;
            //待交换的数的下标
            index = i;
            for (int j = 1; j <= count; j++) {
                int tmp = arr[index];
                arr[index] = arr[i - j];
                arr[i - j] = tmp;
                index = i - j;
            }
        }
    }
}
