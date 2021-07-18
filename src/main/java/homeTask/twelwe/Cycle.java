package homeTask.twelwe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cycle {

    ReentrantLock lock1;
    Condition cond;

    Cycle() {
        lock1 = new ReentrantLock(true);
        cond = lock1.newCondition();
    }

    public void get() {
        while (true) {
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName());
                cond.signal();
                cond.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }
}
