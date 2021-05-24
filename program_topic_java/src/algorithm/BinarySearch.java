package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 7, 9, 11};
        int target = 7;
        BinarySearch bs = new BinarySearch();
        int index = bs.binarySearchRecur(arr, 0, arr.length - 1, target);
        System.out.println(index);
        index=bs.binarySearch(arr,target);
        System.out.println(index);
    }

    public int binarySearch(int[] arr, int target) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return -1;
        }

        int start = 0;
        int end = size - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                while (mid - 1 >= 0) {
                    if (arr[mid - 1] == target) {
                        --mid;
                    } else {
                        break;
                    }
                }

                return mid;
            }
        }

        return -1;
    }

    public int binarySearchRecur(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecur(arr, start, mid - 1, target);
        } else {
            return binarySearchRecur(arr, mid + 1, end, target);
        }
    }
}
