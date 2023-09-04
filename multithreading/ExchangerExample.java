import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger).start();
        new Ivan(exchanger).start();
    }
}
class Mike extends Thread{
    Exchanger<String> exchanger;

    public Mike(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            exchanger.exchange("Hi my name is Mike");
            Thread.sleep(2000);
            exchanger.exchange("I am 20 y.o.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
class Ivan extends Thread{
    Exchanger<String> exchanger;

    public Ivan(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(exchanger.exchange(null));
            System.out.println(exchanger.exchange(null));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
