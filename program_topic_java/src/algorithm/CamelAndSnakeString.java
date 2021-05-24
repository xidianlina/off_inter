package algorithm;

public class CamelAndSnakeString {
    public static void main(String[] args) {
        String s = "get_set_where";
        System.out.println(camelString(s));
        String str = "getSetWhere";
        System.out.println(snakeString(str));
    }

    public static String camelString(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (str.charAt(i) == '_') {
                continue;
            }

            if (i != 0 && str.charAt(i - 1) == '_') {
                sb.append(new Character(str.charAt(i)).toString().toUpperCase());
            } else {
                sb.append(str.charAt(i));
            }
        }

        return new String(sb);
    }

    public static String snakeString(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append('_' + new Character(str.charAt(i)).toString().toLowerCase());
            } else {
                sb.append(str.charAt(i));
            }
        }

        return new String(sb);
    }
}
