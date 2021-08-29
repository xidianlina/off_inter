package test;

/*
    版本号比大小
 */
public class BaiduMain2 {
    public static void main(String[] args) {
        String version1 = "1.1.1";
        String version2 = "1.1.1.2";

        BaiduMain2 main = new BaiduMain2();
        String res = main.getMaxVersion(version1, version2);
        System.out.println(res);
    }

    public String getMaxVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return "equal";
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return version1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return version2;
                }
            }
            return "equal";
        } else {
            return diff > 0 ? version1 : version2;
        }
    }
}
