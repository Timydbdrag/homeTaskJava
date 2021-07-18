package homeTask.twelwe;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private volatile int count = 0;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public int increment2() {
        return counter.getAndIncrement();
    }

    public void increment() {
        synchronized (this) {
            count = count + 1;
        }
    }
    public int getCount() {
        return count;
    }

    public int getCounter() {
        return counter.get();
    }
}