import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore tables = new Semaphore(2);
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i<5; i++){
            personList.add(new Person());
            personList.get(i).table = tables;
        }
        for (Person person : personList){
            person.start();
        }
    }
}

class Person extends Thread {
    Semaphore table;

    @Override
    public void run() {
        System.out.println(this.getName() + "waiting for table");
        try {
            table.acquire();
            System.out.println(this.getName() + "took table and eating");
            Thread.sleep(1000);
            System.out.println(this.getName() + "released table");
            table.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
