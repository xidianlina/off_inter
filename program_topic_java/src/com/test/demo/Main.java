package com.test.demo;

//"(a,(a,b)),v,(b,c)"
public class Main {
    public static void main(String[] args) {
        String str = "(a,(a,b)),v,(b,c)";
        String str2 = "(1,(2,3),(4,(5,6),7))";
        String res = getResult(str2);

        System.out.println(res);
    }

    public static String getResult(String str) {
        if (str == "") {
            return str;
        }
        String res = "";
        char[] ch = str.toCharArray();
        int size = ch.length;
        int num = 0;
        for (int i = 0; i < size; ++i) {
            if (ch[i] != '(' && ch[i] != ')') {
                res += ch[i];
            } else {
                if (ch[i] == '(') {
                    if (num == 0) {
                        res += ch[i];
                    }
                    num++;
                } else {
                    if (ch[i] == ')') {
                        num--;
                    }
                    if (num == 0) {
                        res += ')';
                    }
                }
            }
        }

        return res;
    }
}
