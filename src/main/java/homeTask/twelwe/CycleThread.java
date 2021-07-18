package homeTask.twelwe;

public class CycleThread extends Thread {
    private final Object lock;

    public CycleThread(Object object) {
        this.lock = object;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
