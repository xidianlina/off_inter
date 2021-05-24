package algorithm;

import java.util.Scanner;

public class IpToLong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strIp = sc.nextLine();
            long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String ip) {
        String[] arr = ip.split("\\.");
        long n = Long.parseLong(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            n = n << 8;
            n = n + Long.parseLong(arr[i]);
        }

        return n;
    }

    public static String numToIp(long num) {
        // 先把数字转化为32位的二进制串
        String binaryStr = num2binary(num, 32);
        StringBuilder sb = new StringBuilder();
        // 每8个字符将二进制串转化为十进制数
        for (int i = 0; i < 32; i += 8) {
            String tempStr = binaryStr.substring(i, i + 8);
            int tempInt = 0;
            for (int j = tempStr.length() - 1; j >= 0; j--)
                tempInt += Math.pow(2, tempStr.length() - 1 - j) * (tempStr.charAt(j) - '0');
            sb.append(tempInt + ".");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    private static long ip2num(String[] ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ip.length; i++)
            sb.append(num2binary(Long.parseLong(ip[i]), 8));      // 将数字转化为8位二进制串
        long res = 0;
        String str = sb.toString();
        for (int i = str.length() - 1; i >= 0; i--)
            res += Math.pow(2, str.length() - 1 - i) * (str.charAt(i) - '0');
        return res;
    }

    // 除二取余法
    private static String num2binary(long num, int bit) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
            count++;
        }
        // 高位补0
        while (count < bit) {
            sb.append(0);
            count++;
        }
        return sb.reverse().toString();
    }
}
