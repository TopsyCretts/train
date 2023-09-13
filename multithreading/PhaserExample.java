package multithreading;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser).start();
        new Cleaner(phaser).start();

    }
}
class Washer extends Thread{
    Phaser phaser;

    public Washer(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        for (int i = 0; i< 3; i++){
            System.out.println("washing end");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
class Cleaner extends Thread{
    Phaser phaser;

    public Cleaner(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        for (int i = 0; i< 3; i++){
            System.out.println("cleaning end");
            phaser.arriveAndAwaitAdvance();
        }

    }
}