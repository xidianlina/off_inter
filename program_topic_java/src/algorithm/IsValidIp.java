package algorithm;

import java.util.Scanner;

public class IsValidIp {
    public static void main(String[] args) {
        IsValidIp isValidIp = new IsValidIp();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ip = sc.nextLine();
            System.out.println(isValidIp.isValidIp(ip));
        }
    }

    public boolean isValidIp(String ip) {
        int size = ip.length();
        if (ip.isEmpty() || size < 7 || size > 15) {
            return false;
        }

        String[] arr = ip.split("\\.");
        if (arr.length != 4) {
            return false;
        }

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].length() > 1 && arr[i].charAt(0) == '0') {
                return false;
            }

            for (int j = 0; j < arr[i].length(); ++j) {
                if (arr[i].charAt(j) < '0' || arr[j].charAt(j) > '9') {
                    return false;
                }
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            int tmp = Integer.parseInt(arr[i]);
            if (i == 0) {
                if (tmp < 1 || tmp > 255) {
                    return false;
                }
            } else {
                if (tmp < 0 || tmp > 255) {
                    return false;
                }
            }
        }

        return true;
    }
}
