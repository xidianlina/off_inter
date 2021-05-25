package algorithm;

public class GetPeek {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 6, 4, 1, 0};
        GetPeek gp = new GetPeek();
        gp.getPeek(arr);
    }

    public void getPeek(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 1; i < size; ++i) {
            if (arr[i] < arr[i - 1]) {
                System.out.println(arr[i - 1]);
                break;
            }
        }
    }
}
