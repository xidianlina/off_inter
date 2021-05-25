package algorithm;

import java.util.Scanner;

public class GetDay {
    public static void main(String[] args) {
        GetDay gd = new GetDay();
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int days = gd.getDay(year, month, day);
        System.out.println(days);
    }

    public int getDay(int year, int month, int day) {
        int res = 0;
        int d = 0;
        for (int i = 1; i < month; ++i) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    d = 31;
                    res += d;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 == 0) || year % 400 == 0) {
                        d = 29;
                    } else {
                        d = 28;
                    }
                    res += d;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    d = 30;
                    res += d;
                    break;
            }
        }

        return res + day;
    }
}
