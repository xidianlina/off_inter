package algorithm;

public class FindPrime {
    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
        findPrime.findPrime(34);
        findPrime.findPrime(9);
    }

    private static void findPrime(int n) {
        if (n <= 1) {
            System.out.println(2);
        }
        while (n > 0) {
            if (!isPrime(n)) {
                ++n;
            } else {
                System.out.println(n);
                break;
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
