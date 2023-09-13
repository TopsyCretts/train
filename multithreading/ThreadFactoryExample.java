package multithreading;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("new thread");
                System.out.println("thread was created");
                return t;
            }
        };
        factory.newThread(new Run()).start();

    }

}
