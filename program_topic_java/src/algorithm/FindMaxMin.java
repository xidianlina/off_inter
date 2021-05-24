package algorithm;

/*
要求比较次数为1.5n，使用一般的逐个遍历每个元素然后判断其是否为最大最小值是需要2n次比较的。
现在考虑采用，每次从数组中取出两个元素，判断其大小，然后再分别判断其是否是最大或最小值，
这样一次处理两个元素，每一次比较3次，最终的比较次数就是n/2*3=1.5n。
 */
public class FindMaxMin {
    public static void main(String[] args) {
        int num[] = {2, 4, 5, 6, 8, 3, 7, 1, 9, 10};
        findMaxMin(num);
    }

    private static void findMaxMin(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = size - 1;
        int tmin, tmax;
        int count = 0;
        while (i < j) {
            if (arr[i] < arr[j]) {
                tmax = arr[j];
                tmin = arr[i];
                ++count;
            } else {
                tmax = arr[i];
                tmin = arr[j];
                ++count;
            }
            if (min > tmin) {
                min = tmin;
            }
            if (max < tmax) {
                max = tmax;
            }
            count += 2;
            ++i;
            --j;
        }
        System.out.println("The max number is " + max);
        System.out.println("The min number is " + min);
        System.out.println("Compare number is " + count);
    }
}
