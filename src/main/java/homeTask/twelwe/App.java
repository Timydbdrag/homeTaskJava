package homeTask.twelwe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        //first();
        //second();
        //third();
        //third2();
        fourth();
    }

    private static void first() {
        for (int i = 0; i < 10; i++) {
            new Thread(App::firstHelper).start();
        }
    }

    private static void firstHelper() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    private static void second() {
        Thread thread = new Thread(App::secondHelper);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }

    private static void secondHelper() {
        System.out.println(Thread.currentThread().getState());
    }

    private static void third() {
        Counter counter = new Counter();
        ExecutorService executors = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executors.submit(() -> thirdHelper(counter));
        }

        executors.shutdown();
        try {
            if (!executors.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                executors.shutdown();
            }
        } catch (InterruptedException e) {
            executors.shutdownNow();
        }
        System.out.println("count >>> " + counter.getCount());
    }

    private static void third2() {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> thirdHelper2(counter));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter.getCounter());
    }

    private static void thirdHelper(Counter counter) {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }

    private static void thirdHelper2(Counter counter) {
        for (int i = 0; i < 10000; i++) {
            counter.increment2();
        }
    }

    private static void fourth() {
        Cycle cycle = new Cycle();

        Thread thread1 = new Thread(cycle::get);
        Thread thread2 = new Thread(cycle::get);
        thread1.start();
        thread2.start();

/*        Object obj = new Object();
        new CycleThread(obj).start();
        new CycleThread(obj).start();*/
    }
}
