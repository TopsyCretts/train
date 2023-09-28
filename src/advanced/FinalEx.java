package advanced;

public class FinalEx {

    //final is not constant - final just have 1 time to assigned value
    //we can init in static init or in constructor, not in methods
    // final methods we cant override
    // final classes cant be inherited
    public static void main(String[] args) {

    }
}
class One {
    private final void method(){
        System.out.println("one");
    }
}
class Two extends One{
    public void method(){
        System.out.println("two");
    }
}
//methods arent polymorfed
