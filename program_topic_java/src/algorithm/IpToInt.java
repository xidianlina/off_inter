package algorithm;

import java.util.Scanner;

public class IpToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strIP = sc.nextLine();
            int intIP = ipToInt(strIP);
            System.out.println(intIP);
            System.out.println(intToIp(intIP));
        }
    }

    /*
        ip地址分为四段，每段都是0~255之间的数，每段可以用8位来装下它，4x8=32位，也就是可以将ip地址转为32位的整数
        将ip转为数字其实就是时间换空间的一种方式。String类型的ip占用7(如0.0.0.0)到15(如 255.255.255.255)个字节，而int只需要4个字节
        思路就是将ip的每一段数字转为8位二进制数，并将它们放在结果的适当位置上
     */
    public static int ipToInt(String ip) {
        //取IP的各段
        String[] ipSlices = ip.split("\\.");

        int res = 0;
        for (int i = 0; i < ipSlices.length; ++i) {
            // 将ip的每一段解析为int，并根据位置左移8位
            int intSlice = Integer.parseInt(ipSlices[i]) << 8 * i;
            // 或运算
            res = res | intSlice;
        }

        return res;
    }

    public static String intToIp(int ip) {
        String[] res = new String[4];
        for (int i = 3; i >= 0; --i) {
            int ipInt = (ip >> (8 * i)) & (0xff);
            res[i] = String.valueOf(ipInt);
        }

        return String.join(".", res);
    }
}
