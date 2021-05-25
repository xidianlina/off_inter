package algorithm;

public class MtoN {
    public static void main(String[] args) {
        MtoN mn = new MtoN();
        String str = "9C";
        String res = mn.MToN(str, 16, 8);
        System.out.println(res);
    }

    public String MToN(String str, int m, int n) {
        int[] charToNum = new int[256];
        int[] numToChar = new int[256];

        for (int i = 0; i <= 9; ++i) {
            charToNum['0' + i] = i;
            numToChar[i] = '0' + i;
        }

        for (int i = 10; i <= 35; ++i) {
            charToNum['A' + i - 10] = i;
            numToChar[i] = 'A' + i - 10;
        }

        int realValue = 0;
        int maxChar = numToChar[m];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= maxChar) {
                return "Error Input";
            }

            realValue = realValue * m + charToNum[str.charAt(i)];
        }

        String s = "";
        while (realValue != 0) {
            char ch = (char) numToChar[realValue % n];
            s = ch + s;
            realValue = realValue / n;
        }

        return s;
    }
}
