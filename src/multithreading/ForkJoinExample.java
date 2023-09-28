import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

public class ForkJoinExample {
    static int threads = Runtime.getRuntime().availableProcessors(); // число ядер процессора
    static long value = 100_000_000_000L; // число операций инкрементирования

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(threads); // создаем пул
        System.out.println("with no fork");
        System.out.println(new Date()); // начало вычислений без пула
        long j = 0;
        for (long i = 0; i < value; i++) {
            j++;
        }
        System.out.println(j);
        System.out.println(new Date()); // конец вычислений без пула
        System.out.println("with fork");
        System.out.println(new Date());
        System.out.println(pool.invoke(new MyFork(0, value)));
        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long> {

        long from;
        long to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            long j = 0;
            if (to - from <= value/threads) {
                for (long i = from; i < to; i++){
                    j++;
                }
            } else {
                long middle = (to + from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                MyFork secondHalf = new MyFork(middle, to);

                firstHalf.fork();
                secondHalf.fork();

                return firstHalf.join() + secondHalf.join();
            }
            return j;
        }
    }
}
