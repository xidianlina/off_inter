package algorithm;

public class DiffDay {
    public static void main(String[] args) {
        int year1 = 2017, month1 = 4, day1 = 23;
        int year2 = 2018, month2 = 9, day2 = 25;
        DiffDay diffDay = new DiffDay();
        int diff = diffDay.getDiffDay(year1, month1, day1, year2, month2, day2);
        System.out.println(diff);
    }

    public int getDiffDay(int year1, int month1, int day1, int year2, int month2, int day2) {
        int d1 = getDay(year1, month1, day1);
        int d2 = getDay(year2, month2, day2);

        int res = 0;
        if (year1 == year2) {
            res = Math.abs(year1 - year2);
        } else if (year1 > year2) {
            res = getDaySum(year1, year2, d1, d2);
        } else {
            res = getDaySum(year2, year1, d2, d1);
        }

        return res;
    }

    public int getDaySum(int year1, int year2, int d1, int d2) {
        int res = 0;
        for (int i = year2 + 1; i < year1; ++i) {
            if (isLeap(i)) {
                res += 366;
            } else {
                res += 365;
            }
        }
        res += d1;
        if (isLeap(year2)) {
            res += (366 - d2);
        } else {
            res += (365 - d2);
        }

        return res;
    }

    private int getDay(int year, int month, int day) {
        int days = 0;
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
                    days += d;
                    break;
                case 2:
                    if (isLeap(year)) {
                        d = 29;
                    } else {
                        d = 28;
                    }
                    days += d;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    d = 30;
                    days += d;
                    break;
            }
        }
        return days + day;
    }

    private boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 == 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
