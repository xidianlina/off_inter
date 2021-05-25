package algorithm;

public class OnlyRepeateOnce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 6, 7};
        OnlyRepeateOnce oto = new OnlyRepeateOnce();
        int rep = oto.onlyRepeateOnce(arr);
        System.out.println(rep);
        int res = oto.onlyRepeate(arr);
        System.out.println(res);
    }

    public int onlyRepeateOnce(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i < size; ++i) {
            res ^= arr[i];
        }

        for (int i = 1; i < size; ++i) {
            res ^= i;
        }

        return res;
    }

    /*
        数学推导法: 不重复时sum=1+2+...+ d + (d+1)...+N；现在less=1+2+...+ d + d + (d+1)+...+(N-1)。
        sum和less都有N个数，由于less中只有一个重复的数字d，则必有1<=d<=(N-1)，sum>less。
        sum - less = 0+0+...+ 0 + (-d) + 0...0 + N =(N-d)。所以重复的d=N-(sum-less)。
     */
    public int onlyRepeate(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return -1;
        }
        int sum = 0;
        int less = 0;
        for (int i = 1; i <= size; ++i) {
            sum += i;
        }
        for (int i = 0; i < size; ++i) {
            less += arr[i];
        }
        int res = size - (sum - less);
        return res;
    }
}
