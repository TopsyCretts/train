import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Run());
        new Sportsman(barrier).start();
        new Sportsman(barrier).start();
        new Sportsman(barrier).start();

    }
}
class Run extends Thread{
    @Override
    public void run() {
        System.out.println("run has begun");
    }
}
class Sportsman extends Thread{
    CyclicBarrier barrier;

    public Sportsman(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(this.getName()+" ready");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}