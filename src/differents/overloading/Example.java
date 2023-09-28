package differents.overloading;

public class Example {
    public static void main(String[] args) {
        Example example = new Example();
        //example.method(null);
        example.method(new Parent());
        example.method(new Child());
        //to overload method it must be the same names and args, but it can have different modifiers and returning var
        //when we put null as args of Object types it will be use the least level class
        //but if we don't use classes with relations null will be as error
    }
    private synchronized void method(Parent p){
        System.out.println(p);
    }
    public final void method(Child c){
        System.out.println(c);
    }
}
class Parent {

}
class Child {

}
