package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SheduleExServExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        service.shutdown();
    }
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
