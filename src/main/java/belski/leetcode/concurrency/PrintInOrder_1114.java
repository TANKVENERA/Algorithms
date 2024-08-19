package belski.leetcode.concurrency;

public class PrintInOrder_1114 {

    private boolean isSecondAvailable;
    private boolean isThirdAvailable;

    public PrintInOrder_1114() {
        isSecondAvailable = false;
        isThirdAvailable = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        isSecondAvailable = true;
        notifyAll();

    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        while (!isSecondAvailable) {
            wait();
        }
        printSecond.run();
        isThirdAvailable = true;
        notifyAll();

    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!isThirdAvailable) {
            wait();
        }
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        final PrintInOrder_1114 printInOrder = new PrintInOrder_1114();

        Thread firstThread = new Thread(() -> {
            try {
                printInOrder.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "first-thread");
        Thread scndThread = new Thread(() -> {
            try {
                printInOrder.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "second-thread");
        Thread thrdThread = new Thread(() -> {
            try {
                printInOrder.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "third-thread");

        scndThread.start();
        thrdThread.start();
        firstThread.start();

    }
}
