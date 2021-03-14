package others.order;

public class BubbleSortPos {
    public static void main(String[] args) {
        BubbleSortPos bubbleSortPos = new BubbleSortPos();
        int[] arr = {8, 0, 5, 7, 9, 1, 4, 2, 6, 3};
        bubbleSortPos.printArray(arr);
        bubbleSortPos.bubbleSortPos(arr);
        bubbleSortPos.printArray(arr);
    }

    public void bubbleSortPos(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int i = size - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    pos = j;
                    arr[j + 1] = arr[j + 1] + arr[j];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
            i = pos;
        }
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
}
