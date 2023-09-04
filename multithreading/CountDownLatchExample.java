import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker = new Worker(latch);
        Worker worker2 = new Worker(latch);
        Worker worker3 = new Worker(latch);
        worker.start();
        worker2.start();
        worker3.start();
        latch.await();
        System.out.println("all is done");

    }
}
class Worker extends Thread{
    CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("job is done");
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
