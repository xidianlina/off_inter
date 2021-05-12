package algorithm;

public class ThreadPrint {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; ++i) {
            PrintOddThread odd = new PrintOddThread(i);
            PrintEvenThread even = new PrintEvenThread(i);
            Thread oddThread = new Thread(odd);
            Thread evenThread = new Thread(even);
            oddThread.start();
            evenThread.start();
        }
    }
}

class PrintOddThread implements Runnable {
    private int i;

    public PrintOddThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i % 2 == 1) {
            System.out.println("odd thread " + i);
        }
    }
}

class PrintEvenThread implements Runnable {
    private int i;

    public PrintEvenThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i % 2 == 0) {
            System.out.println("even thread " + i);
        }
    }
}