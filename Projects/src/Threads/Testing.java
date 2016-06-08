package Threads;

/**
 * Created by Happiness on 5.6.2016 г..
 */
public class Testing implements Runnable {
    private Thread t;
    private String threadName;

    public Testing(String name) {
        this.threadName = name;
        System.out.println("Creating thread : " + threadName);
    }

    public void run() {
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
        System.out.println("NISHKA" + threadName + " IZLIZA.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
        }
            t.start();

    }

}

