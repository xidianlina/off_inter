package algorithm;

public class StringToFloat {
    public static void main(String[] args) {
        StringToFloat stf = new StringToFloat();
        float res = stf.stringToFloat("89.432");
        System.out.println(res);
    }

    public float stringToFloat(String str) {
        int size = str.length();
        if (str.isEmpty() || size == 0) {
            return Float.MIN_VALUE;
        }

        float res = 0;
        int sign = 1;
        if (str.charAt(0) == '+') {
            sign = 1;
        } else if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            res += str.charAt(0) - '0';
        } else {
            return Float.MIN_VALUE;
        }

        int index = str.indexOf('.');
        for (int i = 1; i < index; ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return Float.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }

        float total = 0;
        for (int i = index + 1; i < size; ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return Float.MIN_VALUE;
            }
            total = total * 10 + (str.charAt(i) - '0');
        }

        int pos = 1;
        for (int i = 0; i < (size - index - 1); ++i) {
            pos *= 10;
        }

        total = total / pos;

        return sign == 1 ? (res + total) : -(res + total);
    }
}
