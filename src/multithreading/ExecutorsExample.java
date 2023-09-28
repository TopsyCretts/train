package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        //ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(new myRunnable());
        System.out.println(service.submit(new myCallable()).get());
    }
    public static class myRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
    public static class myCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return 2;
        }
    }

}
