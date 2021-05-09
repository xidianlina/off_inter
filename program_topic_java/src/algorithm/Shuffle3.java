package algorithm;

//完美洗牌算法
public class Shuffle3 {
    public static void main(String[] args) {
        Shuffle3 sf = new Shuffle3();
        String[] arr = {"", "a1", "a2", "a3", "a4", "a5", "b1", "b2", "b3", "b4", "b5"};
        sf.PerfectShuffle(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "->" + arr[i] + "\t");
        }
    }

    public void PerfectShuffle(String[] arr) {
        int len = arr.length;
        int n = (len - 1) / 2;
        int start = 0;
        while (n > 1) {
            //第1步：找到2*m = 3^k - 1，使得3^k <= len - 1 < 3^(k + 1)
            int k = 0, m = 1;
            //for (; (len - 1) / m >= 3; k++, m = m * 3) ;
            while ((len - 1) / m >= 3) {
                k++;
                m = m * 3;
            }

            m = m / 2;

            //第2步：把数组中的A[m + 1,...,n + m]那部分循环右移m位
            RightRotate(arr, start, m, n);

            //第3步：对于长度为2*m的数组，刚好有k个圈，每个圈的头部为3^i
            for (int i = 0, t = 1; i < k; i++, t = t * 3) {
                CycleLeader(arr, t, m * 2 + 1);
            }

            //第4步：对数组后面部分A[2m + 1,...,2n]继续递归上面3步
            start = start + m * 2;
            n = n - m;
        }

        //n == 1时
        String temp = arr[1 + start];
        arr[1 + start] = arr[2 + start];
        arr[2 + start] = temp;
        for (int i = 1; i < len; i = i + 2) {
            String a1 = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = a1;
        }
    }

    public void CycleLeader(String[] arr, int start, int mod) {
        for (int i = start * 2 % mod; i != start; i = i * 2 % mod) {
            String temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
        }
    }

    public void Reverse(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public void RightRotate(String[] arr, int start, int m, int n) {
        Reverse(arr, start + m + 1, start + n);
        Reverse(arr, start + n + 1, start + n + m);
        Reverse(arr, start + m + 1, start + n + m);
    }
}