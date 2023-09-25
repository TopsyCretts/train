package advanced;

public class Interfaces {
    public static void main(String[] args) {

    }
}
interface Animal{
    void eat();
    public final int i = 5; //all fields are public final
    public static class InnerClass{
        //all classes are public static
    }
    public static interface InnerInterface{
        //all interfaces are public static
    }
    public static enum InnerEnum{
        //all enums are public static
    }
}
interface Cat extends Animal{
    void move();
}
class Tiger implements Cat, Animal{
    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }
}
